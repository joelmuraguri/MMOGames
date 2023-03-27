package com.joel.data.di

import com.joel.data.network.GamesService
import com.joel.data.repo.GamesRepository
import com.joel.domain.repo.GamesRepo
import com.joel.domain.usecase.GetGameDetailsUseCase
import com.joel.domain.usecase.GetGamesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGamesRepository(
        service: GamesService
    ) : GamesRepo {
        return GamesRepository(service)
    }

    @Provides
    @Singleton
    fun providesGetGamesUseCase( repo: GamesRepo) : GetGamesUseCase{
        return GetGamesUseCase(repo)
    }

    @Provides
    @Singleton
    fun providesGetGameDetailsUseCase(
        repo: GamesRepo
    ) : GetGameDetailsUseCase{
        return GetGameDetailsUseCase(repo)
    }

}