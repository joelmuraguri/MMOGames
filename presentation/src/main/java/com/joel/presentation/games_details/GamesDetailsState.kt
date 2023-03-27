package com.joel.presentation.games_details

import com.joel.domain.model.GameDetails

data class GamesDetailsState(
    val isLoading : Boolean = false,
    val game: GameDetails? = null,
    val error : String = ""
)
