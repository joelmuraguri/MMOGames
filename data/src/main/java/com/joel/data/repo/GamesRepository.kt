package com.joel.data.repo

import com.joel.core.ResourceResult
import com.joel.data.network.GamesService
import com.joel.domain.model.Games
import com.joel.domain.repo.GamesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GamesRepository(
    private val service: GamesService
)  : GamesRepo{

    override suspend fun getGames(): Flow<ResourceResult<List<Games>>>  = flow{
        emit(ResourceResult.Loading())
        try {
            val response = service.getGames()
            emit(ResourceResult.Success(response.map { it.toGamesDomain() }))
        } catch (e : HttpException){
            if (e.code() == 500){
                emit(ResourceResult.Error(error = "Something wrong on our end (unexpected server errors)"))
            } else if (e.code() == 404){
                emit(ResourceResult.Error(error = "Object not found: Game or endpoint not found"))
            } else{
                emit(ResourceResult.Error(error = "Check your Internet Connection"))
            }
        } catch (e : IOException){
           emit(ResourceResult.Error(error = e.message.toString()))
        }
    }

    override suspend fun getGame(): Flow<ResourceResult<Games>> {
        TODO("Not yet implemented")
    }

}