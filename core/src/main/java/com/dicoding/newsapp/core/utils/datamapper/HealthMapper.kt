package com.dicoding.newsapp.core.utils.datamapper

import com.dicoding.newsapp.core.data.source.local.entity.HealthEntity
import com.dicoding.newsapp.core.data.source.remote.response.HealthResponse
import com.dicoding.newsapp.core.domain.model.Health

object HealthMapper {
    fun mapResponsesToEntities(input: List<HealthResponse>): List<HealthEntity> {
        val newsList = ArrayList<HealthEntity>()
        input.map {
            val news = HealthEntity(
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

    fun mapEntitiesToDomain(input: List<HealthEntity>): List<Health> =
        input.map {
            Health(
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

    fun mapDomainToEntity(input: Health) = HealthEntity(
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