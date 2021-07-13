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

data class ListBusinessResponse (

    @field:SerializedName("articles")
    val articles: List<BusinessResponse> = listOf(),

    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    val message: String = ""
)

data class ListSportsResponse (

    @field:SerializedName("articles")
    val articles: List<SportsResponse> = listOf(),

    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    val message: String = ""
)

data class ListHealthResponse (

    @field:SerializedName("articles")
    val articles: List<HealthResponse> = listOf(),

    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    val message: String = ""
)

data class ListScienceResponse (

    @field:SerializedName("articles")
    val articles: List<ScienceResponse> = listOf(),

    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    val message: String = ""
)

data class ListTechnologyResponse (

    @field:SerializedName("articles")
    val articles: List<TechnologyResponse> = listOf(),

    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    val message: String = ""
)

data class ListEntertainmentResponse (

    @field:SerializedName("articles")
    val articles: List<EntertainmentResponse> = listOf(),

    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    val message: String = ""
)
