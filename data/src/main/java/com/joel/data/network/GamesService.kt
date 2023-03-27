package com.joel.data.network

import com.joel.data.remote.dto.GameDTO
import com.joel.data.remote.dto.GamesDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import timber.log.Timber

interface GamesService {

    @GET("games")
    suspend fun getGames() : List<GamesDTO>

    @GET("game")
    suspend fun getGame(@Query(value = "id", encoded = true) id : String) : GameDTO

}