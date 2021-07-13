package com.dicoding.newsapp.home.field.entertainment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EntertainmentViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val entertainmentNews = newsUseCase.getEntertainmentNews().asLiveData()
}