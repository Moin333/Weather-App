package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.theme.WeatherAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme (darkTheme = isSystemInDarkTheme()){
                Box(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background) // Set background color here
                ) {
                    WeatherApp() // Your main screen composable
                }
            }
        }
    }
}

@Composable
fun WeatherApp() {
    val viewModel = WeatherViewModel()
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(viewModel, navController)
        }
        composable("search") {
            SearchScreen(viewModel, navController)
        }
    }
}

