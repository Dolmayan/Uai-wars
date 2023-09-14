package br.com.cambuy.uai.characters.presentation

sealed interface CharactersEvent {
    data class NavigateToCharactersDetail(val id: Int): CharactersEvent
    data class FetchListOfCharacters(val textSearch: String): CharactersEvent
}