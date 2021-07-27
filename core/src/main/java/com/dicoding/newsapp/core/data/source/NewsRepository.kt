package com.dicoding.newsapp.core.data.source

import com.dicoding.newsapp.core.data.source.local.LocalDataSource
import com.dicoding.newsapp.core.data.source.remote.RemoteDataSource
import com.dicoding.newsapp.core.data.source.remote.network.ApiResponse
import com.dicoding.newsapp.core.data.source.remote.response.*
import com.dicoding.newsapp.core.domain.model.*
import com.dicoding.newsapp.core.domain.repository.INewsRepository
import com.dicoding.newsapp.core.utils.AppExecutors
import com.dicoding.newsapp.core.utils.datamapper.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): INewsRepository {

    override fun getHeadlineNews(): Flow<Resource<List<News>>> =
        object : NetworkBoundResource<List<News>, List<NewsResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<News>> {
                return localDataSource.getHeadlineNews().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<News>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<NewsResponse>>> =
                remoteDataSource.getHeadlineNews()

            override suspend fun saveCallResult(data: List<NewsResponse>) {
                val newsList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertNews(newsList)
            }
        }.asFlow()


    override fun getBookmarkNews(): Flow<List<News>> =
        localDataSource.getBookmarkHeadlineNews().map { DataMapper.mapEntitiesToDomain(it) }


    override fun setBookmarkNews(news: News, state: Boolean) {
        val newsEntity = DataMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkNews(newsEntity, state) }
    }

}