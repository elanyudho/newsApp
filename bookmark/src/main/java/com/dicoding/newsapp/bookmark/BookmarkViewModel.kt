package com.dicoding.newsapp.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase

class BookmarkViewModel (newsUseCase: NewsUseCase): ViewModel() {
    val newsBookmark = newsUseCase.getBookmarkNews().asLiveData()

}