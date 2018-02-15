package com.example.macbook.breweryapp

interface BeerRepository {

    fun getBeers(page: Int): Listing<Beer>

}