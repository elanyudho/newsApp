package com.dicoding.newsapp.core.data.source.local.entity

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entertainment")
class EntertainmentEntity (
    @PrimaryKey
    @Nullable

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String = "",

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "author")
    var author: String = "",

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "url")
    var url: String = "",

    @ColumnInfo(name = "content")
    var content: String = "",

    @ColumnInfo(name = "isBookmark")
    var isBookmark: Boolean = false
)