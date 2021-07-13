package com.dicoding.newsapp.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class BookmarkViewModel  (newsUseCase: NewsUseCase): ViewModel() {
    val newsBookmark = newsUseCase.getBookmarkNews().asLiveData()

    val businessBookmark = newsUseCase.getBookmarkBusiness().asLiveData()

    val sportsBookmark = newsUseCase.getBookmarkSports().asLiveData()

    val healthBookmark = newsUseCase.getBookmarkHealth().asLiveData()

    val scienceBookmark = newsUseCase.getBookmarkScience().asLiveData()

    val entertainmentBookmark = newsUseCase.getBookmarkEntertainment().asLiveData()

    val technologyBookmark = newsUseCase.getBookmarkTechnology().asLiveData()

}