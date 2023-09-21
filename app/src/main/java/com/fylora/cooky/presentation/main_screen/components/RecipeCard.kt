package com.fylora.cooky.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fylora.cooky.R
import com.fylora.cooky.domain.model.Recipe

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
) {

    Box(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(23.dp)
            )
            .clip(RoundedCornerShape(23.dp))
            .size(
                width = 260.dp,
                height = 450.dp
            )
    ){
        Card{
            AsyncImage(
                model = recipe.imagePath,
                contentDescription = "Recipe Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xCCFFFFFF),
                            Color.White
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 9.dp,
                        vertical = 18.dp
                    )
            ){
                Text(
                    text = recipe.name,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.indie_flower_regular)),
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = recipe.description,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.indie_flower_regular))
                    )

                    Spacer(modifier = Modifier.weight(1f))

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
            name = "Recipe Name",
            description = "Recipe Description",
            makingTime = "30",
            ingredients = listOf(),
            imagePath = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg?quality=90&resize=556,505",
            id = 8115
        )
    )
}