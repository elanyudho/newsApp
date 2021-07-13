package com.dicoding.newsapp.core.data.source.local.room

import androidx.room.*
import com.dicoding.newsapp.core.data.source.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    /** Get **/
    @Query("SELECT * FROM news")
    fun getHeadlineNews(): Flow<List<NewsEntity>>

    @Query("SELECT * FROM business")
    fun getBusinessNews(): Flow<List<BusinessEntity>>

    @Query("SELECT * FROM sports")
    fun getSportsNews(): Flow<List<SportsEntity>>

    @Query("SELECT * FROM technology")
    fun getTechnologyNews(): Flow<List<TechnologyEntity>>

    @Query("SELECT * FROM health")
    fun getHealthNews(): Flow<List<HealthEntity>>

    @Query("SELECT * FROM entertainment")
    fun getEntertainmentNews(): Flow<List<EntertainmentEntity>>

    @Query("SELECT * FROM science")
    fun getScienceNews(): Flow<List<ScienceEntity>>

    @Query("SELECT * FROM news where isBookmark = 1")
    fun getBookmarkNews(): Flow<List<NewsEntity>>

    @Query("SELECT * FROM business where isBookmark = 1")
    fun getBookmarkBusiness(): Flow<List<BusinessEntity>>

    @Query("SELECT * FROM health where isBookmark = 1")
    fun getBookmarkHealth(): Flow<List<HealthEntity>>

    @Query("SELECT * FROM sports where isBookmark = 1")
    fun getBookmarkSports(): Flow<List<SportsEntity>>

    @Query("SELECT * FROM science where isBookmark = 1")
    fun getBookmarkScience(): Flow<List<ScienceEntity>>

    @Query("SELECT * FROM technology where isBookmark = 1")
    fun getBookmarkTechnology(): Flow<List<TechnologyEntity>>

    @Query("SELECT * FROM entertainment where isBookmark = 1")
    fun getBookmarkEntertainment(): Flow<List<EntertainmentEntity>>


    /** Insert **/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: List<NewsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBusiness(news: List<BusinessEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSports(news: List<SportsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTechnology(news: List<TechnologyEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHealth(news: List<HealthEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntertainment(news: List<EntertainmentEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScience(news: List<ScienceEntity>)

    /** Update **/

    @Update
    fun updateBookmarkNews(news: NewsEntity)

    @Update
    fun updateBookmarkBusiness(news: BusinessEntity)

    @Update
    fun updateBookmarkSports(news: SportsEntity)

    @Update
    fun updateBookmarkTechnology(news: TechnologyEntity)

    @Update
    fun updateBookmarkHealth(news: HealthEntity)

    @Update
    fun updateBookmarkEntertainment(news: EntertainmentEntity)

    @Update
    fun updateBookmarkScience(news: ScienceEntity)
}