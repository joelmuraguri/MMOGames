package com.joel.data.network

import com.joel.data.remote.dto.GamesDTO

interface GamesService {

    suspend fun getGames() : List<GamesDTO>

}