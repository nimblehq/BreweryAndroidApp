package com.example.macbook.breweryapp.ui.github

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.macbook.breweryapp.http.GitHubService
import com.example.macbook.breweryapp.model.NetworkState
import com.example.macbook.breweryapp.model.Repo
import com.example.macbook.breweryapp.paging.github.RepoDataSourceFactory

class GitHubViewModel : ViewModel() {

    companion object {
        private val PAGE_SIZE = 20
    }

    val repos: LiveData<PagedList<Repo>>
    val networkState: LiveData<NetworkState>

    init {
        val factory = RepoDataSourceFactory(GitHubService.service)

        val config = PagedList.Config.Builder()
                .setInitialLoadSizeHint(PAGE_SIZE)
                .setPageSize(PAGE_SIZE)
                .build()

        repos = LivePagedListBuilder(factory, config).build()
        networkState = factory.source.networkState
    }
}