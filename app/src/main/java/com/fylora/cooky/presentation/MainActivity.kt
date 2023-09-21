package com.fylora.cooky.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fylora.cooky.RecipeApplication
import com.fylora.cooky.presentation.main_screen.MainScreen
import com.fylora.cooky.presentation.main_screen.RecipeViewModel
import com.fylora.cooky.presentation.ui.theme.CookyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookyTheme {
                val recipeViewModel = viewModel<RecipeViewModel>(
                    factory = viewModelFactory {
                        RecipeViewModel(RecipeApplication.appModule.useCases)
                    }
                )
                MainScreen(viewModel = recipeViewModel)
            }
        }
    }
}
