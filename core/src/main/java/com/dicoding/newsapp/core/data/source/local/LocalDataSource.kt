package com.dicoding.newsapp.core.data.source.local

import com.dicoding.newsapp.core.data.source.local.entity.*
import com.dicoding.newsapp.core.data.source.local.room.NewsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val newsDao: NewsDao) {

    fun getHeadlineNews(): Flow<List<NewsEntity>> = newsDao.getHeadlineNews()

    fun getBookmarkHeadlineNews(): Flow<List<NewsEntity>> = newsDao.getBookmarkNews()

    suspend fun insertNews(newsList: List<NewsEntity>) = newsDao.insertNews(newsList)

    fun setBookmarkNews(news: NewsEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkNews(news)
    }

}