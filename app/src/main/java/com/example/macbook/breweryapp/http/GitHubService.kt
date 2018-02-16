package com.example.macbook.breweryapp.http

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubService {


    val service: GitHubApi

    init {
        val httpUrl = HttpUrl.parse("https://api.github.com")!!

        service = Retrofit.Builder()
                .baseUrl(httpUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubApi::class.java)
    }
}