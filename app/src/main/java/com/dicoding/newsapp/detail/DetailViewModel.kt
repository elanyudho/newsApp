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

}