package com.dicoding.newsapp.home.field.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val businessNews = newsUseCase.getBusinessNews().asLiveData()
}