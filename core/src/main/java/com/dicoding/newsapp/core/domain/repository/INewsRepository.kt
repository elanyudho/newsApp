package com.dicoding.newsapp.core.domain.repository

import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.domain.model.*
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    /**Get Data News**/
    fun getHeadlineNews(): Flow<Resource<List<News>>>

    fun getBusinessNews(): Flow<Resource<List<Business>>>

    fun getSportsNews(): Flow<Resource<List<Sports>>>

    fun getScienceNews(): Flow<Resource<List<Science>>>

    fun getTechnologyNews(): Flow<Resource<List<Technology>>>

    fun getEntertainmentNews(): Flow<Resource<List<Entertainment>>>

    fun getHealthNews(): Flow<Resource<List<Health>>>

    /**Get Data Bookmark**/

    fun getBookmarkNews(): Flow<List<News>>

    fun getBookmarkBusiness(): Flow<List<Business>>

    fun getBookmarkSports(): Flow<List<Sports>>

    fun getBookmarkScience(): Flow<List<Science>>

    fun getBookmarkTechnology(): Flow<List<Technology>>

    fun getBookmarkEntertainment(): Flow<List<Entertainment>>

    fun getBookmarkHealth(): Flow<List<Health>>

    /**Set Data Bookmark**/

    fun setBookmarkNews(news: News, state: Boolean)

    fun setBookmarkBusiness(news: Business, state: Boolean)

    fun setBookmarkSports(news: Sports, state: Boolean)

    fun setBookmarkScience(news: Science, state: Boolean)

    fun setBookmarkTechnology(news: Technology, state: Boolean)

    fun setBookmarkEntertainment(news: Entertainment, state: Boolean)

    fun setBookmarkHealth(news: Health, state: Boolean)
}