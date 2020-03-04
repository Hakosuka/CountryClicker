package com.ciaranc.countryclicker.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://restcountries-v1.p.rapidapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create()) //get something to support primitive types
    .baseUrl(BASE_URL)
    .build()

interface CountriesApiService {
    //TODO: figure out API keys
    //TODO: ask if I need to hide the API key
    @GET("all")
    @Headers("x-rapidapi-host: restcountries-v1.p.rapidapi.com",
        "x-rapidapi-key: ")
    fun getCountries():
            //TODO: implement Deferred
            Call<String>
}

/**
 * Creating new Retrofit services requires a lot of processing, so the API needs to be created once
 * and then exposed to the rest of the app.
 */
object CountryApi {
    val retrofitService: CountriesApiService by lazy {
        retrofit.create(CountriesApiService::class.java)
    }
}