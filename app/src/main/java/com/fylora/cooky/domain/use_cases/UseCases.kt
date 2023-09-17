package com.fylora.cooky.domain.use_cases

data class UseCases(
    val createRecipeUseCase: CreateRecipeUseCase,
    val deleteRecipesUseCase: DeleteRecipesUseCase,
    val getRecipeByIdUseCase: GetRecipeByIdUseCase,
    val getRecipesUseCase: GetRecipesUseCase,
    val searchRecipesUseCase: SearchRecipesUseCase,
)
