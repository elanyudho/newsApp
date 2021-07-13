package com.dicoding.newsapp.core.data.source.remote.network

import com.dicoding.newsapp.core.data.source.remote.response.*
import retrofit2.http.GET

interface ApiService {
    /**Headline**/
    @GET("top-headlines?country=us&apiKey=5a5fd40cabb44a0a92810e771083030e")
    suspend fun getHeadlineList(): ListNewsResponse

    /**Business**/
    @GET("top-headlines?country=us&category=business&apiKey=5a5fd40cabb44a0a92810e771083030e")
    suspend fun getBusinessList(): ListBusinessResponse

    /**Sports**/
    @GET("top-headlines?country=us&category=sports&apiKey=5a5fd40cabb44a0a92810e771083030e")
    suspend fun getSportsList(): ListSportsResponse

    /**Entertainment**/
    @GET("top-headlines?country=us&category=entertainment&apiKey=5a5fd40cabb44a0a92810e771083030e")
    suspend fun getEntertainmentList(): ListEntertainmentResponse

    /**Technology**/
    @GET("top-headlines?country=us&category=technology&apiKey=5a5fd40cabb44a0a92810e771083030e")
    suspend fun getTechnologyList(): ListTechnologyResponse

    /**Health**/
    @GET("top-headlines?country=us&category=health&apiKey=5a5fd40cabb44a0a92810e771083030e")
    suspend fun getHealthList(): ListHealthResponse

    /**Science**/
    @GET("top-headlines?country=us&category=science&apiKey=5a5fd40cabb44a0a92810e771083030e")
    suspend fun getScienceList(): ListScienceResponse
}