package com.dicoding.newsapp.home.field.sports

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val sportsNews = newsUseCase.getSportsNews().asLiveData()
}