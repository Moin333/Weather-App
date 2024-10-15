package com.example.weatherapp.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

private val LightColorScheme = lightColorScheme(
    primary = Purple500, // Purple 500
    secondary = Teal400, // Teal 200
    background = Color(0xFFFFFFFF), // White
    surface = Color(0xFFFFFFFF), // White
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Purple200, // Purple 200
    secondary = Teal200, // Teal 200
    background = Color(0xFF121212), // Dark Background
    surface = Color(0xFF121212), // Dark Surface
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = false, // Can be changed based on system settings or user choice
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
