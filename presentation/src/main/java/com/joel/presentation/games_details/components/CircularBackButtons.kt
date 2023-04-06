package com.joel.presentation.games_details.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joel.presentation.R

@Composable
fun CircularBackButton(
    onClick : () -> Unit,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
){

    Button(
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        shape = CircleShape,
        elevation = elevation,
        modifier = Modifier
            .width(38.dp)
            .height(38.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White.copy(alpha = 0.3f),
            contentColor = Color.Gray
        )
    ) {
        IconButton(onClick = {
            onClick()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                tint = MaterialTheme.colors.onPrimary,
                contentDescription = null
            )
        }
    }
}