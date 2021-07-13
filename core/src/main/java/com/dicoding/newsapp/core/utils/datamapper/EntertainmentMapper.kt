package com.dicoding.newsapp.core.utils.datamapper

import com.dicoding.newsapp.core.data.source.local.entity.EntertainmentEntity
import com.dicoding.newsapp.core.data.source.remote.response.EntertainmentResponse
import com.dicoding.newsapp.core.domain.model.Entertainment

object EntertainmentMapper {
    fun mapResponsesToEntities(input: List<EntertainmentResponse>): List<EntertainmentEntity> {
        val newsList = ArrayList<EntertainmentEntity>()
        input.map {
            val news = EntertainmentEntity(
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

    fun mapEntitiesToDomain(input: List<EntertainmentEntity>): List<Entertainment> =
        input.map {
            Entertainment(
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

    fun mapDomainToEntity(input: Entertainment) = EntertainmentEntity(
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