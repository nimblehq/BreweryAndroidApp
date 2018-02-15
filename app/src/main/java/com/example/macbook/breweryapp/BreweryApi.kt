package com.example.macbook.breweryapp

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweryApi {

    @GET("/beers")
    fun getBeers(@Query("p") page: Int): Call<ListingResponse>

    class ListingResponse(
            val status: String,
            val data: List<Beer>)

    companion object {
        private const val BASE_URL = "http://api.brewerydb.com/v2/"
        fun create(): BreweryApi = create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl: HttpUrl): BreweryApi {
            val client = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val newRequest = with(chain.request()) {
                            val newUrl = this.url().newBuilder()
                                    .addQueryParameter("key", "ss") //TODO: add key later
                                    .build()

                            this.newBuilder()
                                    .url(newUrl)
                                    .build()
                        }

                        chain.proceed(newRequest)
                    }
                    .build()

            return Retrofit.Builder()
                    .baseUrl(httpUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(BreweryApi::class.java)
        }
    }
}


