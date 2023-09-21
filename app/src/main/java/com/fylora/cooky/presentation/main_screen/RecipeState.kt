package com.fylora.cooky.presentation.main_screen

import com.fylora.cooky.domain.model.Recipe

data class RecipeState(
    val recipeList: List<Recipe> = emptyList()
)
