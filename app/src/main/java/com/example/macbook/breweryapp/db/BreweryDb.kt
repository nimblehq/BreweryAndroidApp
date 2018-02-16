package com.example.macbook.breweryapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.macbook.breweryapp.model.Beer

//@Database(
//        entities = arrayOf(Beer::class),
//        version = 1,
//        exportSchema = false
//)
//abstract class BreweryDb : RoomDatabase() {
//    companion object {
//        fun create(context: Context): BreweryDb =
//                Room.inMemoryDatabaseBuilder(context, BreweryDb::class.java)
//                        .fallbackToDestructiveMigration()
//                        .build()
//
//    }
//
//    abstract fun beers(): BeersDao
//}