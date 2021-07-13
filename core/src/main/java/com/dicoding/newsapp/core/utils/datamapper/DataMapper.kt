package com.dicoding.newsapp.core.utils.datamapper

import com.dicoding.newsapp.core.data.source.local.entity.NewsEntity
import com.dicoding.newsapp.core.data.source.remote.response.NewsResponse
import com.dicoding.newsapp.core.domain.model.News

object DataMapper {

    fun mapResponsesToEntities(input: List<NewsResponse>): List<NewsEntity> {
        val newsList = ArrayList<NewsEntity>()
        input.map {
            val news = NewsEntity(
                publishedAt = it.publishedAt.toString(),
                description = it.description.toString(),
                urlToImage = it.urlToImage.toString(),
                author = it.author.toString(),
                url = it.url.toString(),
                content = it.content.toString(),
                title = it.title.toString(),
                isBookmark = false
            )
            newsList.add(news)
        }
        return newsList
    }

    fun mapEntitiesToDomain(input: List<NewsEntity>): List<News> =
        input.map {
            News(
                publishedAt = it.publishedAt,
                urlToImage = it.urlToImage,
                description = it.description,
                author = it.author,
                title = it.title,
                url = it.url,
                content = it.content,
                isBookmark = it.isBookmark
            )
        }

    fun mapDomainToEntity(input: News) = NewsEntity(
        publishedAt = input.publishedAt,
        urlToImage = input.urlToImage,
        description = input.description,
        author = input.author,
        title = input.title,
        url = input.url,
        content = input.content,
        isBookmark = input.isBookmark
    )
}