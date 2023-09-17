package com.fylora.cooky.data.data_sources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fylora.cooky.data.entity.RecipeEntity

@Database(
    entities = [RecipeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RecipeDatabase: RoomDatabase() {

    abstract val dao: RecipeDao
}