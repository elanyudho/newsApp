package com.dicoding.newsapp.core.data.source.local

import com.dicoding.newsapp.core.data.source.local.entity.*
import com.dicoding.newsapp.core.data.source.local.room.NewsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val newsDao: NewsDao) {

    fun getHeadlineNews(): Flow<List<NewsEntity>> = newsDao.getHeadlineNews()

    fun getBusinessNews(): Flow<List<BusinessEntity>> = newsDao.getBusinessNews()

    fun getSportsNews(): Flow<List<SportsEntity>> = newsDao.getSportsNews()

    fun getTechnologyNews(): Flow<List<TechnologyEntity>> = newsDao.getTechnologyNews()

    fun getScienceNews(): Flow<List<ScienceEntity>> = newsDao.getScienceNews()

    fun getHealthNews(): Flow<List<HealthEntity>> = newsDao.getHealthNews()

    fun getEntertainmentNews(): Flow<List<EntertainmentEntity>> = newsDao.getEntertainmentNews()

    fun getBookmarkHeadlineNews(): Flow<List<NewsEntity>> = newsDao.getBookmarkNews()

    fun getBookmarkBusinessNews(): Flow<List<BusinessEntity>> = newsDao.getBookmarkBusiness()

    fun getBookmarkHealthNews(): Flow<List<HealthEntity>> = newsDao.getBookmarkHealth()

    fun getBookmarkSportsNews(): Flow<List<SportsEntity>> = newsDao.getBookmarkSports()

    fun getBookmarkScienceNews(): Flow<List<ScienceEntity>> = newsDao.getBookmarkScience()

    fun getBookmarkEntertainmentNews(): Flow<List<EntertainmentEntity>> = newsDao.getBookmarkEntertainment()

    fun getBookmarkTechnologyNews(): Flow<List<TechnologyEntity>> = newsDao.getBookmarkTechnology()

    suspend fun insertNews(newsList: List<NewsEntity>) = newsDao.insertNews(newsList)

    suspend fun insertBusiness(newsList: List<BusinessEntity>) = newsDao.insertBusiness(newsList)

    suspend fun insertEntertainment(newsList: List<EntertainmentEntity>) = newsDao.insertEntertainment(newsList)

    suspend fun insertScience(newsList: List<ScienceEntity>) = newsDao.insertScience(newsList)

    suspend fun insertHealth(newsList: List<HealthEntity>) = newsDao.insertHealth(newsList)

    suspend fun insertSports(newsList: List<SportsEntity>) = newsDao.insertSports(newsList)

    suspend fun insertTechnology(newsList: List<TechnologyEntity>) = newsDao.insertTechnology(newsList)

    fun setBookmarkNews(news: NewsEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkNews(news)
    }

    fun setBookmarkBusiness(news: BusinessEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkBusiness(news)
    }

    fun setBookmarkEntertainment(news: EntertainmentEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkEntertainment(news)
    }

    fun setBookmarkScience(news: ScienceEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkScience(news)
    }

    fun setBookmarkHealth(news: HealthEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkHealth(news)
    }

    fun setBookmarkSports(news: SportsEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkSports(news)
    }

    fun setBookmarkTechnology(news: TechnologyEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkTechnology(news)
    }
}