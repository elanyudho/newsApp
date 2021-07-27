package com.dicoding.newsapp.core.domain.usecase

import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.domain.model.*
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getHeadlineNews(): Flow<Resource<List<News>>>

    fun getBookmarkNews(): Flow<List<News>>

    fun setBookmarkNews(news: News, state: Boolean)

}