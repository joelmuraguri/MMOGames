package com.joel.data.network

import com.joel.data.remote.dto.GameDTO
import com.joel.data.remote.dto.GamesDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesService {

    @GET("games")
    suspend fun getGames() : List<GamesDTO>

    @GET("game/{id}")
    suspend fun getGame(
        @Query("id") id : Int
    ) : GameDTO

}