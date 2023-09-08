package br.com.cambuy.uai.wars.ui.theme

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
    )
)