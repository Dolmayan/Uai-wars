package br.com.cambuy.uai.wars.characters

sealed interface CharactersEvent {
    data class NavigateToCharactersDetail(val id: Int): CharactersEvent
}