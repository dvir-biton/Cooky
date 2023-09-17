package com.fylora.cooky.domain.model

data class Recipe(
    val name: String,
    val description: String,
    val makingTime: String,
    val ingredients: List<Ingredient>,
    val id: Int = 0
)

data class Ingredient(
    val name: String,
    val quantity: Int
)

class InvalidRecipeException(message: String): Exception(message)