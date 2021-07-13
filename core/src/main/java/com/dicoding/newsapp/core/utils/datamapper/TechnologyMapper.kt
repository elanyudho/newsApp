package com.dicoding.newsapp.core.utils.datamapper

import com.dicoding.newsapp.core.data.source.local.entity.TechnologyEntity
import com.dicoding.newsapp.core.data.source.remote.response.TechnologyResponse
import com.dicoding.newsapp.core.domain.model.Technology

object TechnologyMapper {
    fun mapResponsesToEntities(input: List<TechnologyResponse>): List<TechnologyEntity> {
        val newsList = ArrayList<TechnologyEntity>()
        input.map {
            val news = TechnologyEntity(
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

    fun mapEntitiesToDomain(input: List<TechnologyEntity>): List<Technology> =
        input.map {
            Technology(
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

    fun mapDomainToEntity(input: Technology) = TechnologyEntity(
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