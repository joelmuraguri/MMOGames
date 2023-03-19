package com.joel.presentation.game_list.components

import com.joel.domain.model.Games

data class GamesState(
    val games : List<Games> = emptyList(),
    val loading : Boolean = false,
    val error : String ? = null

)
