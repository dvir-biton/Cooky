package com.fylora.cooky.domain.use_cases

import com.fylora.cooky.domain.model.Recipe
import com.fylora.cooky.domain.repository.RecipeRepository

class CreateRecipeUseCase(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(recipe: Recipe){
        if(ValidateRecipeUseCase().isRecipeValid(recipe))
            repository.createRecipe(recipe)
    }
}