package com.joel.presentation.game_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.joel.presentation.game_list.components.GameItem

@Composable
fun GamesListScreen(
    viewModel: GamesViewModel = hiltViewModel()
) {

    val state = viewModel.gamesState.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(state.games.size){index -> 
                GameItem(games = state.games[index])
            }
        }
        if(state.error != null) {
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
        if(state.loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }




}