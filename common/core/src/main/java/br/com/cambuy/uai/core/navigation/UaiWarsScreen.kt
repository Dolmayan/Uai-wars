package br.com.cambuy.uai.core.navigation

sealed class UaiWarsScreen(val route: String) {
    object CharactersScreen : UaiWarsScreen(CHARACTERS_SCREEN)
    data class CharactersDetailScreen(val id: Int) : UaiWarsScreen(CHARACTERS_DETAIL_SCREEN)
    object NavigateUp : UaiWarsScreen(BACK_PRESSED)

    companion object {
        const val SPLASH_SCREEN = "splash_screen"
        const val CHARACTERS_SCREEN = "characters_screen"
        const val CHARACTERS_DETAIL_SCREEN = "characters_detail_screen"
        const val BACK_PRESSED = "back_press"
    }
}