package com.example.macbook.breweryapp

import java.util.concurrent.Executor

class DbBeerRepository(
        val db: BreweryDb,
        private val breweryApi: BreweryApi,
        private val ioExecutor: Executor,
        private val networkPageSize: Int = DEFAULT_NETWORK_PAGE_SIZE) : BeerRepository {

    companion object {
        private val DEFAULT_NETWORK_PAGE_SIZE = 50
    }

    override fun getBeers(page: Int): Listing<Beer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}