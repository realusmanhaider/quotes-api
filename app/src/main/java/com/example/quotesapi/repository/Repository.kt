package com.example.quotesapi.repository

import com.example.quotesapi.network.api.ApiService
import javax.inject.Inject


class Repository @Inject constructor( private val apiService: ApiService) {
    suspend fun getQuotes(category: String)= apiService.getQuotes( "67d249dfdcmsh6095a303fa23adbp14a07ajsn03b1dad6cdd0", "famous-quotes4.p.rapidapi.com",category, 10)
}