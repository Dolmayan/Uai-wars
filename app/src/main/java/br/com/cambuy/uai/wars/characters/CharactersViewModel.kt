package br.com.cambuy.uai.wars.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cambuy.characters.domain.useCase.GetCharactersUseCase
import br.com.cambuy.uai.core.util.Debounce
import br.com.cambuy.uai.wars.navigation.UaiWarsScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CharactersViewModel(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

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
            Debounce.debounce(coroutineScope = viewModelScope, text = textSearch) {
                when (val result = getCharactersUseCase())
            }
        }
    }
}