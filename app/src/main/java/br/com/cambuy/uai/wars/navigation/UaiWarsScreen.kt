package br.com.cambuy.uai.wars.navigation

import br.com.cambuy.uai.wars.MainActivity.Companion.BACK_PRESSED
import br.com.cambuy.uai.wars.MainActivity.Companion.CHARACTERS_DETAIL_SCREEN
import br.com.cambuy.uai.wars.MainActivity.Companion.CHARACTERS_SCREEN

sealed class UaiWarsScreen(val route: String) {
    object CharactersScreen: UaiWarsScreen(CHARACTERS_SCREEN)
    data class CharactersDetailScreen(val id: Int): UaiWarsScreen(CHARACTERS_DETAIL_SCREEN)
    object NavigateUp: UaiWarsScreen(BACK_PRESSED)
}