package com.dicoding.newsapp.core.di

import com.dicoding.newsapp.core.data.source.NewsRepository
import com.dicoding.newsapp.core.domain.repository.INewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(newsRepository: NewsRepository): INewsRepository
}