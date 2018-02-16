package com.example.macbook.breweryapp.paging.github

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import com.example.macbook.breweryapp.http.GitHubApi
import com.example.macbook.breweryapp.model.NetworkState
import com.example.macbook.breweryapp.model.Repo
import java.io.IOException

class PageKeyedRepoDataSource(private val api: GitHubApi) : PageKeyedDataSource<Int, Repo>() {

    val networkState = MutableLiveData<NetworkState>()

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Repo>) {
        // Nothing Implement
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Repo>) {
        callApi(params.key, params.requestedLoadSize) { repos, next ->
            callback.onResult(repos, next)
        }
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Repo>) {
        callApi(1, params.requestedLoadSize) { repos, next ->
            callback.onResult(repos, null, next)
        }
    }

    private fun callApi(page: Int, perPage: Int, callback: (repos: List<Repo>, next: Int?) -> Unit) {
        networkState.postValue(NetworkState.LOADING)

        var state = NetworkState.ERROR

        try {
            val reponse = api.repos("nimbl3", page, perPage).execute()

            reponse.body()?.let {
                var next: Int? = null
                reponse.headers().get("Link")?.let {
                    val regex = Regex("rel=\"next\"")
                    if (regex.containsMatchIn(it)) {
                        next = page + 1
                    }
                }

                callback(it, next)
                state = NetworkState.LOADED
            }
        } catch (e: IOException) {
            // Do nothing
        }

        networkState.postValue(state)
    }
}