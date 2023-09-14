package br.com.cambuy.uai.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = yellow,
    onPrimary = white,
    surface = white,
    background = darkGrey,
    onBackground = greyBackground
)

private val LightColorPalette = lightColorScheme(
    primary = yellow,
    onPrimary = white,
    surface = white,
    background = darkGrey,
    onBackground = greyBackground
)

@Composable
fun UaiWarsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}