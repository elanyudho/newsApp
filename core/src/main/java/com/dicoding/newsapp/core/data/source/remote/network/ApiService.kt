package com.dicoding.newsapp.core.data.source.remote.network

import com.dicoding.newsapp.core.data.source.remote.network.ApiVariable.key
import com.dicoding.newsapp.core.data.source.remote.response.*
import retrofit2.http.GET

interface ApiService {

    /**Headline**/
    @GET("top-headlines?country=us&apiKey=${key}")
    suspend fun getHeadlineList(): ListNewsResponse

    /**Business**/
    @GET("top-headlines?country=us&category=business&apiKey=${key}")
    suspend fun getBusinessList(): ListBusinessResponse

    /**Sports**/
    @GET("top-headlines?country=us&category=sports&apiKey=${key}")
    suspend fun getSportsList(): ListSportsResponse

    /**Entertainment**/
    @GET("top-headlines?country=us&category=entertainment&apiKey=${key}")
    suspend fun getEntertainmentList(): ListEntertainmentResponse

    /**Technology**/
    @GET("top-headlines?country=us&category=technology&apiKey=${key}")
    suspend fun getTechnologyList(): ListTechnologyResponse

    /**Health**/
    @GET("top-headlines?country=us&category=health&apiKey=${key}")
    suspend fun getHealthList(): ListHealthResponse

    /**Science**/
    @GET("top-headlines?country=us&category=science&apiKey=${key}")
    suspend fun getScienceList(): ListScienceResponse
}