package br.com.cambuy.uai.wars.characters

import br.com.cambuy.uai.wars.navigation.UaiWarsScreen

sealed interface CharactersUiEvent {
    data class NavigateTo(val route: UaiWarsScreen): CharactersUiEvent
    object NavigateUp: CharactersUiEvent
}