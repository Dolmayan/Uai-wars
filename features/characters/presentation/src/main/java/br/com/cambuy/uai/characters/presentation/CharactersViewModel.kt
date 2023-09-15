package br.com.cambuy.uai.characters.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cambuy.characters.domain.useCase.GetCharactersUseCase
import br.com.cambuy.uai.core.navigation.UaiWarsScreen
import br.com.cambuy.uai.design_system.StateOfUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()

    private val _uiEvent = Channel<CharactersUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: CharactersEvent) {
        viewModelScope.launch {
            when (event) {
                is CharactersEvent.NavigateToCharactersDetail -> navigateTo(
                    UaiWarsScreen.CharactersDetailScreen(
                        event.id
                    )
                )

                is CharactersEvent.FetchListOfCharacters -> fetchListOfCharacters(event.textSearch)
            }
        }
    }

    private fun navigateTo(route: UaiWarsScreen) {
        viewModelScope.launch {
            _uiEvent.send(CharactersUiEvent.NavigateTo(route))
        }
    }

    private fun fetchListOfCharacters(textSearch: String) {
        viewModelScope.launch(Dispatchers.IO) {
            updateStateOfUi(StateOfUi.Loading)
            runCatching {
                val data = getCharactersUseCase(textSearch)
                updateStateOfUi(StateOfUi.View)
                _state.update { it.copy(listOfCharacters = data) }
            }.getOrElse {
                updateStateOfUi(StateOfUi.Error { fetchListOfCharacters(textSearch) })
            }
        }
    }


    private fun updateStateOfUi(stateOfUi: StateOfUi) {
        _state.update {
            it.copy(stateOfUi = stateOfUi)
        }
    }
}