package com.fylora.cooky.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    val name: String,
    val description: String,
    val makingTime: String,
    val ingredients: String,
    val imagePath: String? = null,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
