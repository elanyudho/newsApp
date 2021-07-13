package com.dicoding.newsapp.core.utils.datamapper

import com.dicoding.newsapp.core.data.source.local.entity.BusinessEntity
import com.dicoding.newsapp.core.data.source.remote.response.BusinessResponse
import com.dicoding.newsapp.core.domain.model.Business

object BusinessMapper {
    fun mapResponsesToEntities(input: List<BusinessResponse>): List<BusinessEntity> {
        val newsList = ArrayList<BusinessEntity>()
        input.map {
            val news = BusinessEntity(
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

    fun mapEntitiesToDomain(input: List<BusinessEntity>): List<Business> =
        input.map {
            Business(
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

    fun mapDomainToEntity(input: Business) = BusinessEntity(
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