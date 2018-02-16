package com.example.macbook.breweryapp.http

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BreweryService {

    val service: BreweryApi

    init {
        val httpUrl = HttpUrl.parse("http://api.brewerydb.com/v2/")!!
        val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val newRequest = with(chain.request()) {
                        val newUrl = this.url().newBuilder()
                                .addQueryParameter("key", "ss") //TODO: add key later 9741e805409497a470490a9e9a3908d8
                                .build()

                        this.newBuilder()
                                .url(newUrl)
                                .build()
                    }

                    chain.proceed(newRequest)
                }
                .build()

        service = Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BreweryApi::class.java)
    }
}