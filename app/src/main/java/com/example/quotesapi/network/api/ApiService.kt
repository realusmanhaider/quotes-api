package com.example.quotesapi.network.api

import com.example.quotesapi.data.model.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {


    @GET("/random")
    suspend fun getQuotes(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String,
        @Query("category") category: String,
        @Query("count") count : Int ): Response<List<QuoteResponse>>

}