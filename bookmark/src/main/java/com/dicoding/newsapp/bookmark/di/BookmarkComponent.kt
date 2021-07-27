package com.dicoding.newsapp.bookmark.di

import android.content.Context
import com.dicoding.newsapp.bookmark.BookmarkActivity
import com.dicoding.newsapp.di.BookmarkModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [BookmarkModuleDependencies::class])
interface BookmarkComponent {

    fun injectNewsHeadline(activity: BookmarkActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(bookmarkModuleDependencies: BookmarkModuleDependencies): Builder
        fun build(): BookmarkComponent
    }
}