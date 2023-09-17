package com.fylora.cooky.data.mappers

import com.fylora.cooky.data.entity.RecipeEntity
import com.fylora.cooky.domain.model.Ingredient
import com.fylora.cooky.domain.model.Recipe
import com.google.gson.Gson

fun RecipeEntity.toRecipe(): Recipe {
    return Recipe(
        name = name,
        description = description,
        makingTime = makingTime,
        ingredients = ingredients.toIngredientList(),
        id = id
    )
}

fun Recipe.toRecipeEntity(): RecipeEntity {
    return RecipeEntity(
        name = name,
        description = description,
        makingTime = makingTime,
        ingredients = ingredients.toJsonString(),
        id = id
    )
}

fun List<Ingredient>.toJsonString(): String {
    return Gson().toJson(this)
}

fun String.toIngredientList(): List<Ingredient> {
    return Gson().fromJson(this, Array<Ingredient>::class.java).toList()
}