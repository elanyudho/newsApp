package com.dicoding.newsapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val publishedAt: String,
    val urlToImage: String,
    val description: String,
    val author: String,
    val title: String,
    val url: String,
    val content: String,
    val isBookmark: Boolean
): Parcelable