package com.dicoding.newsapp.core.data.source.remote.network

import com.dicoding.newsapp.core.data.source.remote.network.ApiVariable.key
import com.dicoding.newsapp.core.data.source.remote.response.*
import retrofit2.http.GET

interface ApiService {

    /**Headline**/
    @GET("top-headlines?country=us&apiKey=${key}")
    suspend fun getHeadlineList(): ListNewsResponse

}