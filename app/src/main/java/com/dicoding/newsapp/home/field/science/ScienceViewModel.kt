package com.dicoding.newsapp.home.field.science

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScienceViewModel @Inject constructor(newsUseCase: NewsUseCase): ViewModel() {
    val scienceNews = newsUseCase.getScienceNews().asLiveData()
}