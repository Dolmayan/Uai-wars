package br.com.cambuy.uai.wars.ui.navigationBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.CHARACTERS_SCREEN
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.COMICS_SCREEN
import br.com.cambuy.uai.core.navigation.UaiWarsScreen.Companion.SETTINGS_SCREEN

sealed class BottomNavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object Characters : BottomNavigationItem(
        route = CHARACTERS_SCREEN,
        title = "Personagens",
        icon = Icons.Default.Person
    )

    object Comics : BottomNavigationItem(
        route = COMICS_SCREEN,
        title = "Quadrinhos",
        icon = Icons.Default.Create
    )

    object Settings : BottomNavigationItem(
        route = SETTINGS_SCREEN,
        title = "Configurações",
        icon = Icons.Default.Settings
    )
}
