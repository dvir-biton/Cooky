package com.fylora.cooky.domain.use_cases

import com.fylora.cooky.domain.model.Recipe
import com.fylora.cooky.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class GetRecipesUseCase(
    private val repository: RecipeRepository
) {
    operator fun invoke(): Flow<List<Recipe>> {
        return repository.getRecipes()
    }
}