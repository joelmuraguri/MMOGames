package com.joel.data.repo

import com.joel.core.ResourceResult
import com.joel.data.network.GamesService
import com.joel.domain.model.GameDetails
import com.joel.domain.model.Games
import com.joel.domain.repo.GamesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.util.*

class GamesRepository(
    private val service: GamesService
) : GamesRepo{


    override suspend fun getGames(): Flow<ResourceResult<List<Games>>>  = flow{
        emit(ResourceResult.Loading())
        try {
            val response = service.getGames()
            Timber.d("FETCHED GAMES -> SUCCESS")
            emit(ResourceResult.Success(response.map { it.toGamesDomain() }))
        } catch (e : HttpException){
            if (e.code() == 500){
                emit(ResourceResult.Error(error = "Something wrong on our end (unexpected server errors)"))
            } else if (e.code() == 404){
                emit(ResourceResult.Error(error = "Object not found: Game or endpoint not found"))
            } else{
                emit(ResourceResult.Error(error =  e.localizedMessage ?: "An expected Error Occurred"))
            }
        } catch (e : IOException){
           emit(ResourceResult.Error(error = "Couldn't reach Server. Check your Internet Connection"))
        }
    }

    override suspend fun getGame(id: String): Flow<ResourceResult<GameDetails>>  = flow{
        emit(ResourceResult.Loading())
        try {
            val apiResponse = service.getGame(id)
            val gameDetails = apiResponse.toGameDomain()
            Timber.d(gameDetails.title.toUpperCase(Locale.ROOT))
            emit(ResourceResult.Success(gameDetails))
        } catch ( e: HttpException){
            if (e.code() == 500){
                Timber.d("Error 500")
                emit(ResourceResult.Error(error = "Something wrong on our end (unexpected server errors)"))
            } else if (e.code() == 404){
                emit(ResourceResult.Error(error = "Object not found: Game or endpoint not found"))
            } else{
                emit(ResourceResult.Error(error = e.localizedMessage ?: "An expected Error Occurred"))
            }
        } catch (e : IOException){
            emit(ResourceResult.Error(error = "Check your Internet Connection"))
        }
    }

}