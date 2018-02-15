package com.example.macbook.breweryapp

import android.arch.persistence.room.Dao

@Dao
interface BeersDao {
    fun insert()

    fun beers()
}