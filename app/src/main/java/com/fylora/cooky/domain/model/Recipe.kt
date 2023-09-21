package com.fylora.cooky.domain.model

import com.fylora.cooky.R

data class Recipe(
    val name: String = "",
    val description: String = "",
    val makingTime: String = "",
    val ingredients: List<Ingredient> = emptyList(),
    val imagePath: String = blankImage,
    val id: Int = 0
) {
    companion object {
        val blankImage = "android.resource://com.fylora.cooky/${R.drawable.blank}"
    }
}

data class Ingredient(
    val name: String,
    val quantity: Int
)

class InvalidRecipeException(message: String): Exception(message)