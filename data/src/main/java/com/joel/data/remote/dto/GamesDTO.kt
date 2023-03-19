package com.joel.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.joel.domain.model.Games


data class GamesDTO(
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freeToGameProfileUrl: String,
    val game_url: String,
    val genre: String,
    val id: Int,
    val platform: String,
    val publisher: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("short_description")
    val shortDescription: String,
    val thumbnail: String,
    val title: String
) {
    fun toGamesDomain() : Games{
        return Games(
            id =  id,
            title = title,
            thumbnail = thumbnail,
            genre = genre,
            publisher = publisher
        )
    }
}