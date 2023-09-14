package br.com.cambuy.uai.characters.presentation

import br.com.cambuy.uai.core.navigation.UaiWarsScreen

sealed interface CharactersUiEvent {
    data class NavigateTo(val route: UaiWarsScreen): CharactersUiEvent
    object NavigateUp: CharactersUiEvent
}