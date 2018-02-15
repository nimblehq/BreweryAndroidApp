package com.example.macbook.breweryapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(
        entities = arrayOf(Beer::class),
        version = 1,
        exportSchema = false
)
abstract class BreweryDb : RoomDatabase() {
    companion object {
        fun create(context: Context): BreweryDb =
                Room.inMemoryDatabaseBuilder(context, BreweryDb::class.java)
                        .fallbackToDestructiveMigration()
                        .build()

    }

    abstract fun beers(): BeersDao
}