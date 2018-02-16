package com.example.macbook.breweryapp.repository

import com.example.macbook.breweryapp.model.Listing
import com.example.macbook.breweryapp.model.Beer

interface BeerRepository {

    fun getBeers(page: Int): Listing<Beer>

}