package com.fylora.cooky.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.cooky.R
import com.fylora.cooky.domain.model.Recipe

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {

    Box {
        Card(
            modifier = modifier
                .clip(RoundedCornerShape(23.dp))
        ){
            
        }
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 23.dp,
                        bottomEnd = 23.dp
                    )
                )
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(9.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = recipe.name,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.indie_flower_regular)),
                )
                Row {
                    Text(
                        text = recipe.name,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.indie_flower_regular)),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = recipe.description,
                        fontSize = 28.sp,
                        fontFamily = FontFamily(Font(R.font.indie_flower_regular)),
                    )
                    Text(
                        text = "${recipe.makingTime} min",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.indie_flower_regular)),
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Prev() {
    RecipeCard(
        recipe = Recipe(
            name = "Amy Hardin",
            description = "tantas",
            makingTime = "fermentum",
            ingredients = listOf(),
            id = 8115
        )
    )
}