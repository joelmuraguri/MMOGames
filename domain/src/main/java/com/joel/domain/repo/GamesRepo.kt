package com.joel.domain.repo

import com.joel.core.ResourceResult
import com.joel.domain.model.Game
import com.joel.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface GamesRepo {

    suspend fun getGames() : Flow<ResourceResult<List<Games>>>

    suspend fun getGame() : Flow<ResourceResult<Games>>

}