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

    override fun getBusinessNews(): Flow<Resource<List<Business>>> =

        object : NetworkBoundResource<List<Business>, List<BusinessResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Business>> {
                return localDataSource.getBusinessNews().map { BusinessMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Business>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<BusinessResponse>>> =
                remoteDataSource.getBusinessNews()

            override suspend fun saveCallResult(data: List<BusinessResponse>) {
                val newsList = BusinessMapper.mapResponsesToEntities(data)
                localDataSource.insertBusiness(newsList)
            }
        }.asFlow()

    override fun getSportsNews(): Flow<Resource<List<Sports>>> =
        object : NetworkBoundResource<List<Sports>, List<SportsResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Sports>> {
                return localDataSource.getSportsNews().map { SportsMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Sports>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<SportsResponse>>> =
                remoteDataSource.getSportsNews()

            override suspend fun saveCallResult(data: List<SportsResponse>) {
                val newsList = SportsMapper.mapResponsesToEntities(data)
                localDataSource.insertSports(newsList)
            }
        }.asFlow()

    override fun getScienceNews(): Flow<Resource<List<Science>>> =
        object : NetworkBoundResource<List<Science>, List<ScienceResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Science>> {
                return localDataSource.getScienceNews().map { ScienceMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Science>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ScienceResponse>>> =
                remoteDataSource.getScienceNews()

            override suspend fun saveCallResult(data: List<ScienceResponse>) {
                val newsList = ScienceMapper.mapResponsesToEntities(data)
                localDataSource.insertScience(newsList)
            }
        }.asFlow()

    override fun getTechnologyNews(): Flow<Resource<List<Technology>>> =
        object : NetworkBoundResource<List<Technology>, List<TechnologyResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Technology>> {
                return localDataSource.getTechnologyNews().map { TechnologyMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Technology>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TechnologyResponse>>> =
                remoteDataSource.getTechnologyNews()

            override suspend fun saveCallResult(data: List<TechnologyResponse>) {
                val newsList = TechnologyMapper.mapResponsesToEntities(data)
                localDataSource.insertTechnology(newsList)
            }
        }.asFlow()

    override fun getEntertainmentNews(): Flow<Resource<List<Entertainment>>> =
        object : NetworkBoundResource<List<Entertainment>, List<EntertainmentResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Entertainment>> {
                return localDataSource.getEntertainmentNews().map { EntertainmentMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Entertainment>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<EntertainmentResponse>>> =
                remoteDataSource.getEntertainmentNews()

            override suspend fun saveCallResult(data: List<EntertainmentResponse>) {
                val newsList = EntertainmentMapper.mapResponsesToEntities(data)
                localDataSource.insertEntertainment(newsList)
            }
        }.asFlow()

    override fun getHealthNews(): Flow<Resource<List<Health>>> =
        object : NetworkBoundResource<List<Health>, List<HealthResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Health>> {
                return localDataSource.getHealthNews().map { HealthMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Health>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<HealthResponse>>> =
                remoteDataSource.getHealthNews()

            override suspend fun saveCallResult(data: List<HealthResponse>) {
                val newsList = HealthMapper.mapResponsesToEntities(data)
                localDataSource.insertHealth(newsList)
            }
        }.asFlow()

    override fun getBookmarkNews(): Flow<List<News>> =
        localDataSource.getBookmarkHeadlineNews().map { DataMapper.mapEntitiesToDomain(it) }

    override fun getBookmarkBusiness(): Flow<List<Business>> =
        localDataSource.getBookmarkBusinessNews().map { BusinessMapper.mapEntitiesToDomain(it) }

    override fun getBookmarkSports(): Flow<List<Sports>> =
        localDataSource.getBookmarkSportsNews().map { SportsMapper.mapEntitiesToDomain(it) }

    override fun getBookmarkScience(): Flow<List<Science>> =
        localDataSource.getBookmarkScienceNews().map { ScienceMapper.mapEntitiesToDomain(it) }

    override fun getBookmarkTechnology(): Flow<List<Technology>> =
        localDataSource.getBookmarkTechnologyNews().map { TechnologyMapper.mapEntitiesToDomain(it) }

    override fun getBookmarkEntertainment(): Flow<List<Entertainment>> =
        localDataSource.getBookmarkEntertainmentNews().map { EntertainmentMapper.mapEntitiesToDomain(it) }

    override fun getBookmarkHealth(): Flow<List<Health>> =
        localDataSource.getBookmarkHealthNews().map { HealthMapper.mapEntitiesToDomain(it) }

    override fun setBookmarkNews(news: News, state: Boolean) {
        val newsEntity = DataMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkNews(newsEntity, state) }
    }

    override fun setBookmarkBusiness(news: Business, state: Boolean) {
        val businessEntity = BusinessMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkBusiness(businessEntity, state) }
    }

    override fun setBookmarkSports(news: Sports, state: Boolean) {
        val sportsEntity = SportsMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkSports(sportsEntity, state) }
    }

    override fun setBookmarkScience(news: Science, state: Boolean) {
        val scienceEntity = ScienceMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkScience(scienceEntity, state) }
    }

    override fun setBookmarkTechnology(news: Technology, state: Boolean) {
        val technologyEntity = TechnologyMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkTechnology(technologyEntity, state) }
    }

    override fun setBookmarkEntertainment(news: Entertainment, state: Boolean) {
        val entertainmentEntity = EntertainmentMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkEntertainment(entertainmentEntity, state) }
    }

    override fun setBookmarkHealth(news: Health, state: Boolean) {
        val healthEntity = HealthMapper.mapDomainToEntity(news)
        appExecutors.diskIO().execute { localDataSource.setBookmarkHealth(healthEntity, state) }
    }

}