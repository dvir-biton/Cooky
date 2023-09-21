package com.fylora.cooky.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.cooky.R
import com.fylora.cooky.presentation.main_screen.components.BottomBarItem
import com.fylora.cooky.presentation.main_screen.components.RecipeCard
import com.fylora.cooky.presentation.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: RecipeViewModel
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "What are we making\ntoday?",
                    fontSize = 40.sp,
                    fontFamily = FontFamily(Font(R.font.indie_flower_regular)),
                    textAlign = TextAlign.Center,
                    lineHeight = 58.sp
                )
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                var selectedIndex by rememberSaveable {
                    mutableIntStateOf(1)
                }
                listOf(
                    R.drawable.search,
                    R.drawable.home,
                    R.drawable.shopping_cart
                ).onEachIndexed { index, icon ->
                    BottomBarItem(
                        icon = icon,
                        isSelected = index == selectedIndex
                    ) {
                        selectedIndex = index
                    }
                }
            }
        }
    ){ padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyRow() {
                items(viewModel.recipesState.value.recipeList) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        modifier = Modifier.padding(14.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(33.dp))
                    .background(Primary)
                    .clickable {

                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "Add recipe",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.indie_flower_regular)),
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}