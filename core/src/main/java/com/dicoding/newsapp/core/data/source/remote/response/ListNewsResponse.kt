package com.dicoding.newsapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListNewsResponse (

    @field:SerializedName("articles")
    val articles: List<NewsResponse> = listOf(),

    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    val message: String = ""
)
