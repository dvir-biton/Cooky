package com.fylora.cooky.domain.repository

import com.fylora.cooky.data.entity.RecipeEntity
import com.fylora.cooky.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun getRecipes(): Flow<List<Recipe>>

    fun searchRecipes(query: String): Flow<List<Recipe>>

    suspend fun getRecipeById(id: Int): Recipe

    suspend fun createRecipe(recipe: Recipe)

    suspend fun deleteRecipe(recipe: Recipe)
}