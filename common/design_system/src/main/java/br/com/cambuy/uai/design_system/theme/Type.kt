package br.com.cambuy.uai.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with

val defaultTextStyle = TextStyle(
    fontSize = 14.sp
)

val Typography = Typography(
    bodySmall = defaultTextStyle.copy(
        fontSize = 12.sp,
        lineHeight = (14.1).sp,
        letterSpacing = (0.5).sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = defaultTextStyle.copy(
        lineHeight = (16.45).sp
    ),
    bodyLarge = defaultTextStyle.copy(
        fontSize = 16.sp,
        lineHeight = (18.8).sp
    ),

    // Title
    titleSmall = defaultTextStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    titleMedium = defaultTextStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = (23.5).sp
    ),
    titleLarge = defaultTextStyle.copy(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 28.sp
    ),

    // Headline
    headlineSmall = defaultTextStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = (28.2).sp
    ),
    headlineMedium = defaultTextStyle.copy(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    ),
    headlineLarge = defaultTextStyle.copy(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
)