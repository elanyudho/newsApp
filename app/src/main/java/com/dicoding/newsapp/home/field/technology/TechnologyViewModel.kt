package com.dicoding.newsapp.home.field.technology

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TechnologyViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val technologyNews = newsUseCase.getTechnologyNews().asLiveData()
}