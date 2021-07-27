package com.dicoding.newsapp.core.domain.usecase

import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.domain.model.*
import com.dicoding.newsapp.core.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsInteractor @Inject constructor(private val newsRepository: INewsRepository) : NewsUseCase {
    override fun getHeadlineNews(): Flow<Resource<List<News>>> =
        newsRepository.getHeadlineNews()

    override fun getBookmarkNews(): Flow<List<News>> =
        newsRepository.getBookmarkNews()

    override fun setBookmarkNews(news: News, state: Boolean) =
        newsRepository.setBookmarkNews(news, state)
}