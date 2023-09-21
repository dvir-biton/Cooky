package com.fylora.cooky.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fylora.cooky.R
import com.fylora.cooky.presentation.ui.theme.Primary

@Composable
fun BottomBarItem(
    isSelected: Boolean = false,
    color: Color = Primary,
    icon: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(if (isSelected) color else MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ){
        IconButton(
            onClick = onClick,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = if(isSelected) MaterialTheme.colorScheme.background else color,
            )
        }
    }
}

@Preview
@Composable
fun BottomBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        BottomBarItem(icon = R.drawable.search) {

        }
        BottomBarItem(icon = R.drawable.home) {

        }
        BottomBarItem(icon = R.drawable.shopping_cart) {

        }
    }
}