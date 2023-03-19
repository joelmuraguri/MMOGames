package com.joel.presentation.game_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.core.ResourceResult
import com.joel.domain.usecase.GetGamesUseCase
import com.joel.presentation.game_list.components.GamesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val getGamesUseCase : GetGamesUseCase
) : ViewModel() {


    private val _gamesState = mutableStateOf(GamesState())
    val gamesState : State<GamesState> = _gamesState

    init {
        getGames()
    }

    fun getGames(){
        viewModelScope.launch {
            getGamesUseCase().onEach { result ->
                when(result){
                    is ResourceResult.Success -> {
                        _gamesState.value = GamesState(
                            games = result.data ?: emptyList()
                        )
                    }
                    is ResourceResult.Error -> {
                        _gamesState.value = GamesState(
                            error = result.error ?: "An unexpected error occurred"
                        )
                    }
                    is ResourceResult.Loading -> {
                        _gamesState.value = GamesState(
                            loading = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}