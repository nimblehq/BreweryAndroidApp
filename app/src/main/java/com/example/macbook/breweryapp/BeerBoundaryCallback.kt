package com.example.macbook.breweryapp

import android.arch.paging.PagedList
import android.support.annotation.MainThread
import java.util.concurrent.Executor

class BeerBoundaryCallback(
        private val webService: BreweryApi,
        private val ioExecutor: Executor,
        private val networkPageSize: Int)
    : PagedList.BoundaryCallback<Beer>() {

    @MainThread
    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
    }

    @MainThread
    override fun onItemAtEndLoaded(itemAtEnd: Beer) {
        super.onItemAtEndLoaded(itemAtEnd)
    }

}