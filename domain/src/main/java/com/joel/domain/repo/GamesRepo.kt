package com.joel.domain.repo

import com.joel.domain.model.Games

interface GamesRepo {

    suspend fun getGames() : List<Games>
}