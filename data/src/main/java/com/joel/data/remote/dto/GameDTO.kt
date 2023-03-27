package com.joel.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.joel.domain.model.GameDetails

data class GameDTO(
    val description: String,
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String,
    @SerializedName("game_url")
    val gameUrl: String,
    val genre: String,
    val id: Int,
    @SerializedName("minimum_system_requirements")
    val minimumSystemRequirements: MinimumSystemRequirementsDTO,
    val platform: String,
    val publisher: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val screenshots: List<ScreenshotDTO>,
    @SerializedName("short_description")
    val shortDescription: String,
    val status: String,
    val thumbnail: String,
    val title: String
) {
    fun toGameDomain() : GameDetails{
        return GameDetails(
           id = id,
            title = title,
            description = description,
            developer = developer,
            thumbnail = thumbnail,
            platform = platform,
            publisher = publisher,
            freetogameProfileUrl = freetogameProfileUrl,
            releaseDate = releaseDate,
            status = status,
            genre = genre
        )
    }
}