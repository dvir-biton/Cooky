package com.fylora.cooky.data.repository

import com.fylora.cooky.data.data_sources.RecipeDao
import com.fylora.cooky.data.entity.RecipeEntity
import com.fylora.cooky.data.mappers.toRecipe
import com.fylora.cooky.data.mappers.toRecipeEntity
import com.fylora.cooky.domain.model.Recipe
import com.fylora.cooky.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepositoryImpl(
    private val dao: RecipeDao
): RecipeRepository {

    override fun getRecipes(): Flow<List<Recipe>> {
        return dao.getRecipes().map {
            it.map { recipe ->
                recipe.toRecipe()
            }
        }
    }

    override fun searchRecipes(query: String): Flow<List<Recipe>> {
        return dao.searchRecipes(query).map {
            it.map { recipe ->
                recipe.toRecipe()
            }
        }
    }

    override suspend fun getRecipeById(id: Int): Recipe {
        return dao.getRecipeById(id).toRecipe()
    }

    override suspend fun createRecipe(recipe: Recipe) {
        dao.createRecipe(recipe.toRecipeEntity())
    }

    override suspend fun deleteRecipe(recipe: Recipe) {
        dao.deleteRecipe(recipe.toRecipeEntity())
    }
}