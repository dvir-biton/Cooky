package com.fylora.cooky.domain.use_cases

import com.fylora.cooky.domain.model.Recipe
import com.fylora.cooky.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class SearchRecipesUseCase(
    private val repository: RecipeRepository
){

    operator fun invoke(query: String): Flow<List<Recipe>> {
        return repository.searchRecipes(query)
    }
}