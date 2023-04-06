package com.joel.presentation.games_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joel.presentation.games_details.components.GameImageBanner
import com.joel.presentation.games_details.components.GameInfo

@Composable
fun GamesDetailsScreen(
    viewModel: GamesDetailsViewModel = hiltViewModel(),
    onBackPressed : () -> Unit
){

    val scrollState = rememberLazyListState()
    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        state.game?.let { game ->
            GameInfo(
                scrollState = scrollState,
                releaseDate = game.releaseDate,
                description = game.description
            )
            GameImageBanner(
                scrollState = scrollState,
                onBackPressed = { onBackPressed() },
                gameName = game.title,
                gameStatus = game.status,
                gameUrl = game.thumbnail
            )
        }

        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .scale(0.5f)
            )
        }
    }
}