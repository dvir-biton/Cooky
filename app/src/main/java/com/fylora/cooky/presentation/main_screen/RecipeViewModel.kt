package com.fylora.cooky.presentation.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylora.cooky.domain.use_cases.UseCases
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val useCases: UseCases
): ViewModel() {

    private var _recipesState = mutableStateOf(RecipeState())
    val recipesState = _recipesState

    init {
        viewModelScope.launch {
            useCases.getRecipesUseCase().collectLatest {
                _recipesState.value = recipesState.value.copy(
                    recipeList = it
                )
            }
        }
    }
}