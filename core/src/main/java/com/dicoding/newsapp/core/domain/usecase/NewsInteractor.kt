package com.dicoding.newsapp.core.domain.usecase

import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.domain.model.*
import com.dicoding.newsapp.core.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsInteractor @Inject constructor(private val newsRepository: INewsRepository) : NewsUseCase {
    override fun getHeadlineNews(): Flow<Resource<List<News>>> =
        newsRepository.getHeadlineNews()

    override fun getBusinessNews(): Flow<Resource<List<Business>>> =
        newsRepository.getBusinessNews()

    override fun getSportsNews(): Flow<Resource<List<Sports>>> =
        newsRepository.getSportsNews()

    override fun getEntertainmentNews(): Flow<Resource<List<Entertainment>>> =
        newsRepository.getEntertainmentNews()

    override fun getHealthNews(): Flow<Resource<List<Health>>> =
        newsRepository.getHealthNews()

    override fun getTechnologyNews(): Flow<Resource<List<Technology>>> =
        newsRepository.getTechnologyNews()

    override fun getScienceNews(): Flow<Resource<List<Science>>> =
        newsRepository.getScienceNews()

    override fun getBookmarkNews(): Flow<List<News>> =
        newsRepository.getBookmarkNews()

    override fun getBookmarkBusiness(): Flow<List<Business>> =
        newsRepository.getBookmarkBusiness()

    override fun getBookmarkSports(): Flow<List<Sports>> =
        newsRepository.getBookmarkSports()

    override fun getBookmarkEntertainment(): Flow<List<Entertainment>> =
        newsRepository.getBookmarkEntertainment()

    override fun getBookmarkHealth(): Flow<List<Health>> =
        newsRepository.getBookmarkHealth()

    override fun getBookmarkTechnology(): Flow<List<Technology>> =
        newsRepository.getBookmarkTechnology()

    override fun getBookmarkScience(): Flow<List<Science>> =
        newsRepository.getBookmarkScience()


    override fun setBookmarkNews(news: News, state: Boolean) =
        newsRepository.setBookmarkNews(news, state)

    override fun setBookmarkBusiness(news: Business, state: Boolean) {
        newsRepository.setBookmarkBusiness(news, state)
    }

    override fun setBookmarkScience(news: Science, state: Boolean) {
        newsRepository.setBookmarkScience(news, state)
    }

    override fun setBookmarkSports(news: Sports, state: Boolean) {
        newsRepository.setBookmarkSports(news, state)
    }

    override fun setBookmarkHealth(news: Health, state: Boolean) {
        newsRepository.setBookmarkHealth(news, state)
    }

    override fun setBookmarkEntertainment(news: Entertainment, state: Boolean) {
        newsRepository.setBookmarkEntertainment(news, state)
    }

    override fun setBookmarkTechnology(news: Technology, state: Boolean) {
        newsRepository.setBookmarkTechnology(news, state)
    }

}