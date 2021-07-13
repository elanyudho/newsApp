package com.dicoding.newsapp.core.utils.datamapper

import com.dicoding.newsapp.core.data.source.local.entity.SportsEntity
import com.dicoding.newsapp.core.data.source.remote.response.SportsResponse
import com.dicoding.newsapp.core.domain.model.Sports

object SportsMapper {
    fun mapResponsesToEntities(input: List<SportsResponse>): List<SportsEntity> {
        val newsList = ArrayList<SportsEntity>()
        input.map {
            val news = SportsEntity(
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

    fun mapEntitiesToDomain(input: List<SportsEntity>): List<Sports> =
        input.map {
            Sports(
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

    fun mapDomainToEntity(input: Sports) = SportsEntity(
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