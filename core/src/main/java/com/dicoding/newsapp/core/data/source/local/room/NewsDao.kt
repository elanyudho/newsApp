package com.dicoding.newsapp.core.data.source.local.room

import androidx.room.*
import com.dicoding.newsapp.core.data.source.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    /** Get **/
    @Query("SELECT * FROM news")
    fun getHeadlineNews(): Flow<List<NewsEntity>>

    @Query("SELECT * FROM news where isBookmark = 1")
    fun getBookmarkNews(): Flow<List<NewsEntity>>


    /** Insert **/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsEntity>)


    /** Update **/

    @Update
    fun updateBookmarkNews(news: NewsEntity)

}