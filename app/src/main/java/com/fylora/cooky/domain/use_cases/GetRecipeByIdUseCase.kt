package com.fylora.cooky.domain.use_cases

import com.fylora.cooky.domain.model.Recipe
import com.fylora.cooky.domain.repository.RecipeRepository

class GetRecipeByIdUseCase(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(id: Int): Recipe {
        return repository.getRecipeById(id)
    }
}