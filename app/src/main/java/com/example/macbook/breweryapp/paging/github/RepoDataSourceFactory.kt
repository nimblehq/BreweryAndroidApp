package com.example.macbook.breweryapp.paging.github

import android.arch.paging.DataSource
import com.example.macbook.breweryapp.http.GitHubApi
import com.example.macbook.breweryapp.model.Repo

class RepoDataSourceFactory(private val api: GitHubApi) : DataSource.Factory<Int, Repo> {
    val source = PageKeyedRepoDataSource(api)

    override fun create(): DataSource<Int, Repo> {
        return source
    }
}