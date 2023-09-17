package com.fylora.cooky.domain.use_cases

import com.fylora.cooky.domain.model.InvalidRecipeException
import com.fylora.cooky.domain.model.Recipe

class ValidateRecipeUseCase {

     fun isRecipeValid(recipe: Recipe): Boolean {

        if(recipe.name.isBlank()) {
            throw InvalidRecipeException("The title of the recipe cannot be blank!")
        }
        if(recipe.description.isBlank()) {
            throw InvalidRecipeException("The description of the recipe cannot be blank!")
        }
        if(recipe.makingTime == "0") {
            throw InvalidRecipeException("The making time of the recipe cannot be instant!")
        }
        if(recipe.ingredients.any { it.quantity == 0 }) {
            throw InvalidRecipeException("It doesn't look like you need some ingredients here!\ningredients cannot have 0 quantity!")
        }
        if(recipe.ingredients.any { it.name == "" }) {
            throw InvalidRecipeException("Looks like some ingredients don't have a name!\nhow can you make a recipe without knowing the ingredients!")
        }
        if(recipe.ingredients.isEmpty()) {
            throw InvalidRecipeException("What kind of recipe is this?\nyou have no ingredients!")
        }

        return true
    }
}