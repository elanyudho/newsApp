package com.dicoding.newsapp.core.domain.repository

import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.domain.model.*
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    /**Get Data News**/
    fun getHeadlineNews(): Flow<Resource<List<News>>>

    /**Get Data Bookmark**/

    fun getBookmarkNews(): Flow<List<News>>

    /**Set Data Bookmark**/

    fun setBookmarkNews(news: News, state: Boolean)

}