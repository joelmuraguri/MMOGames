package com.joel.domain.model

data class GameDetails(
    val id: Int,
    val title: String,
    val description: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val freetogameProfileUrl: String,
    val thumbnail: String,
    val status: String,
    val releaseDate: String,
    val developer: String,
)
