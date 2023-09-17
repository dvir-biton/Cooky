package com.fylora.cooky.core.di

import android.content.Context
import androidx.room.Room
import com.fylora.cooky.data.data_sources.RecipeDatabase
import com.fylora.cooky.data.repository.RecipeRepositoryImpl
import com.fylora.cooky.domain.repository.RecipeRepository
import com.fylora.cooky.domain.use_cases.CreateRecipeUseCase
import com.fylora.cooky.domain.use_cases.DeleteRecipesUseCase
import com.fylora.cooky.domain.use_cases.GetRecipeByIdUseCase
import com.fylora.cooky.domain.use_cases.GetRecipesUseCase
import com.fylora.cooky.domain.use_cases.SearchRecipesUseCase
import com.fylora.cooky.domain.use_cases.UseCases

interface AppModule {
    val db: RecipeDatabase
    val repository: RecipeRepository
    val useCases: UseCases
}

class AppModuleImpl(
    private val appContext: Context
): AppModule {

    override val db: RecipeDatabase by lazy {
        Room.databaseBuilder(
            context = appContext,
            klass = RecipeDatabase::class.java,
            name = "recipe_database"
        ).build()
    }

    override val repository: RecipeRepository by lazy {
        RecipeRepositoryImpl(db.dao)
    }

    override val useCases: UseCases by lazy {
        UseCases(
            createRecipeUseCase = CreateRecipeUseCase(repository = repository),
            deleteRecipesUseCase = DeleteRecipesUseCase(repository = repository),
            getRecipeByIdUseCase = GetRecipeByIdUseCase(repository = repository),
            getRecipesUseCase = GetRecipesUseCase(repository = repository),
            searchRecipesUseCase = SearchRecipesUseCase(repository = repository)
        )
    }
}