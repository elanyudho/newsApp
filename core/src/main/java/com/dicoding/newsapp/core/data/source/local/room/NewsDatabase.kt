package com.dicoding.newsapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.newsapp.core.data.source.local.entity.*

@Database(
    entities = [NewsEntity::class, BusinessEntity::class, SportsEntity::class, ScienceEntity::class, HealthEntity::class, TechnologyEntity::class, EntertainmentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}