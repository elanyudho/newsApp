package com.dicoding.newsapp.di

import com.dicoding.newsapp.core.domain.usecase.NewsInteractor
import com.dicoding.newsapp.core.domain.usecase.NewsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideNewsUseCase(newsInteractor: NewsInteractor): NewsUseCase
}