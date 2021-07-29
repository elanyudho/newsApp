package com.dicoding.newsapp.di

import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface BookmarkModuleDependencies {

    fun newsUseCase(): NewsUseCase
}