package com.dicoding.newsapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.newsapp.core.domain.model.*
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val newsUseCase: NewsUseCase): ViewModel() {
    fun setBookmarkNews(news: News, newStatus: Boolean) =
        newsUseCase.setBookmarkNews(news, newStatus)

    fun setBookmarkBusiness(news: Business, newStatus: Boolean) =
        newsUseCase.setBookmarkBusiness(news, newStatus)

    fun setBookmarkHealth(news: Health, newStatus: Boolean) =
        newsUseCase.setBookmarkHealth(news, newStatus)

    fun setBookmarkScience(news: Science, newStatus: Boolean) =
        newsUseCase.setBookmarkScience(news, newStatus)

    fun setBookmarkSports(news: Sports, newStatus: Boolean) =
        newsUseCase.setBookmarkSports(news, newStatus)

    fun setBookmarkTechnology(news: Technology, newStatus: Boolean) =
        newsUseCase.setBookmarkTechnology(news, newStatus)

    fun setBookmarkEntertainment(news: Entertainment, newStatus: Boolean) =
        newsUseCase.setBookmarkEntertainment(news, newStatus)
}