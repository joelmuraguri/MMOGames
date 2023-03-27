package com.joel.presentation.games_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.core.ResourceResult
import com.joel.core.Utils
import com.joel.domain.usecase.GetGameDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GamesDetailsViewModel @Inject constructor(
    private val getGameUseCase: GetGameDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(GamesDetailsState())
    val state : State<GamesDetailsState> = _state

    init {
        savedStateHandle.get<String>(Utils.PARAM_GAME_ID)?.let { id ->
            Timber.d(id)
            getGameDetails(id)
        }
    }

    private fun getGameDetails(id :String) {
        viewModelScope.launch {
            getGameUseCase(id).onEach { result ->
                when(result){
                    is ResourceResult.Error -> {
                        _state.value = GamesDetailsState(
                            error = result.error ?: "An unexpected error occurred"
                        )
                    }
                    is ResourceResult.Loading -> {
                        _state.value = GamesDetailsState(
                            isLoading = true
                        )
                    }
                    is ResourceResult.Success -> {
                        _state.value = GamesDetailsState(
                            game = result.data
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}