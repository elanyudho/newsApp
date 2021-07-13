package com.dicoding.newsapp.home.field.health

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HealthViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val healthNews = newsUseCase.getHealthNews().asLiveData()
}