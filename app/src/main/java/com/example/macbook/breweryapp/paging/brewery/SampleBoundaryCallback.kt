package com.example.macbook.breweryapp.paging.brewery

import android.arch.paging.PagedList
import com.example.macbook.breweryapp.model.Beer

class SampleBoundaryCallback : PagedList.BoundaryCallback<Beer>() {
    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()

    }

    override fun onItemAtEndLoaded(itemAtEnd: Beer) {
        super.onItemAtEndLoaded(itemAtEnd)
    }

    override fun onItemAtFrontLoaded(itemAtFront: Beer) {
        super.onItemAtFrontLoaded(itemAtFront)
    }
}