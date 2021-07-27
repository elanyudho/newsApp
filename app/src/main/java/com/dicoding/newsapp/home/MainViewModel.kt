package com.dicoding.newsapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val newsHeadline = newsUseCase.getHeadlineNews().asLiveData()
}