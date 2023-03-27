package com.joel.domain.repo

import com.joel.core.ResourceResult
import com.joel.domain.model.GameDetails
import com.joel.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface GamesRepo {

    suspend fun getGames() : Flow<ResourceResult<List<Games>>>

    suspend fun getGame(id : String) : Flow<ResourceResult<GameDetails>>

}