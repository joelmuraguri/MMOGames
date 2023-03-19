package com.joel.domain.usecase

import com.joel.core.ResourceResult
import com.joel.domain.model.Games
import com.joel.domain.repo.GamesRepo
import kotlinx.coroutines.flow.Flow

class GetGamesUseCase(
    private val repo: GamesRepo
) {
    suspend operator fun invoke() : Flow<ResourceResult<List<Games>>>{
        return repo.getGames()
    }

}