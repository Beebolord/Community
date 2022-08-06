package com.example.ticket.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import com.forest.community.android.ui.Typography

private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = Color.White,
    secondary = Color.White,
    surface = LightPink,
    background = Whiteish,
)

private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = Color.White,
    secondary = Color.White,
    surface = Orange,
    background = Whiteish,


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CommunityTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}