package com.joel.domain.usecase

import com.joel.core.ResourceResult
import com.joel.domain.model.GameDetails
import com.joel.domain.repo.GamesRepo
import kotlinx.coroutines.flow.Flow

class GetGameDetailsUseCase(
    private val repo: GamesRepo
) {

    suspend operator fun invoke(id : String) : Flow<ResourceResult<GameDetails>>{
        return repo.getGame(id)
    }
}