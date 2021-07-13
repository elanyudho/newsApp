package com.dicoding.newsapp.core.utils.datamapper

import com.dicoding.newsapp.core.data.source.local.entity.ScienceEntity
import com.dicoding.newsapp.core.data.source.remote.response.ScienceResponse
import com.dicoding.newsapp.core.domain.model.Science

object ScienceMapper {
    fun mapResponsesToEntities(input: List<ScienceResponse>): List<ScienceEntity> {
        val newsList = ArrayList<ScienceEntity>()
        input.map {
            val news = ScienceEntity(
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

    fun mapEntitiesToDomain(input: List<ScienceEntity>): List<Science> =
        input.map {
            Science(
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

    fun mapDomainToEntity(input: Science) = ScienceEntity(
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