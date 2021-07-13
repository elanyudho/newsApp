package com.dicoding.newsapp.bookmark

import android.content.Context
import com.dicoding.newsapp.bookmark.field.business.BookmarkBusinessFragment
import com.dicoding.newsapp.bookmark.field.entertainment.BookmarkEntertainmentFragment
import com.dicoding.newsapp.bookmark.field.headline.BookmarkNewsHeadlineFragment
import com.dicoding.newsapp.bookmark.field.health.BookmarkHealthFragment
import com.dicoding.newsapp.bookmark.field.science.BookmarkScienceFragment
import com.dicoding.newsapp.bookmark.field.sports.BookmarkSportsFragment
import com.dicoding.newsapp.bookmark.field.technology.BookmarkTechnologyFragment
import com.dicoding.newsapp.di.AppModule
import com.dicoding.newsapp.di.BookmarkModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [BookmarkModuleDependencies::class])
interface BookmarkComponent {

    fun injectNewsHeadline(fragment: BookmarkNewsHeadlineFragment)

    fun injectBusiness(fragment: BookmarkBusinessFragment)

    fun injectEntertainment(fragment: BookmarkEntertainmentFragment)

    fun injectHealth(fragment: BookmarkHealthFragment)

    fun injectScience(fragment: BookmarkScienceFragment)

    fun injectSports(fragment: BookmarkSportsFragment)

    fun injectTechnology(fragment: BookmarkTechnologyFragment)


    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(bookmarkModuleDependencies: BookmarkModuleDependencies): Builder
        fun build(): BookmarkComponent
    }
}