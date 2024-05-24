package com.example.quotesapi.data.model

import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    @SerializedName("id") var id  : Int? = null,
    @SerializedName("text") var text  : String? = null,
    @SerializedName("author") var author : String? = null,
    @SerializedName("category") var category : String? = null
)
