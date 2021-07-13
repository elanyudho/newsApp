package com.dicoding.newsapp.core.domain.usecase

import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.domain.model.*
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getHeadlineNews(): Flow<Resource<List<News>>>

    fun getBusinessNews(): Flow<Resource<List<Business>>>

    fun getSportsNews(): Flow<Resource<List<Sports>>>

    fun getEntertainmentNews(): Flow<Resource<List<Entertainment>>>

    fun getHealthNews(): Flow<Resource<List<Health>>>

    fun getTechnologyNews(): Flow<Resource<List<Technology>>>

    fun getScienceNews(): Flow<Resource<List<Science>>>

    fun getBookmarkNews(): Flow<List<News>>

    fun getBookmarkBusiness(): Flow<List<Business>>

    fun getBookmarkSports(): Flow<List<Sports>>

    fun getBookmarkEntertainment(): Flow<List<Entertainment>>

    fun getBookmarkHealth(): Flow<List<Health>>

    fun getBookmarkTechnology(): Flow<List<Technology>>

    fun getBookmarkScience(): Flow<List<Science>>

    fun setBookmarkNews(news: News, state: Boolean)

    fun setBookmarkBusiness(news: Business, state: Boolean)

    fun setBookmarkScience(news: Science, state: Boolean)

    fun setBookmarkSports(news: Sports, state: Boolean)

    fun setBookmarkHealth(news: Health, state: Boolean)

    fun setBookmarkEntertainment(news: Entertainment, state: Boolean)

    fun setBookmarkTechnology(news: Technology, state: Boolean)

}