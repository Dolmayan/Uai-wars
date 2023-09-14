package br.com.cambuy.uai.design_system.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val tiny: Dp = 2.dp,
    val extraSmall: Dp = 4.dp,
    val smallAlt: Dp = 6.dp,
    val small: Dp = 8.dp,
    val mediumAlt: Dp = 12.dp,
    val medium: Dp = 16.dp,
    val largeAlt: Dp = 24.dp,
    val large: Dp = 32.dp,
    val extraLargeAlt: Dp = 40.dp,
    val extraLargeMedium: Dp = 44.dp,
    val extraLarge: Dp = 48.dp,
    val hugeAlt: Dp = 56.dp,
    val huge: Dp = 64.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current