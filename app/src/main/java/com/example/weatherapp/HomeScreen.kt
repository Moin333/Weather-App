package com.example.weatherapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.ui.theme.Amber
import com.example.weatherapp.ui.theme.Amber100

@Composable
fun HomeScreen(viewModel: WeatherViewModel, navController: NavController) {
    val weather = viewModel.weatherData.observeAsState()
    val error = viewModel.errorMessage.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Weather App",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Amber
        )

        Spacer(modifier = Modifier.height(24.dp))

        when {
            weather.value != null -> {
                WeatherDetails(weather = weather.value!!)
            }
            error.value != null -> {
                Text(text = error.value ?: "Error occurred", color = Color.Red)
            }
            else -> {
                // Loading state (add progress indicator if needed)
                Text(
                    text = "Loading...",
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Add a button to navigate to the SearchScreen
        Button(onClick = { navController.navigate("search") }) {
            Text(
                text = "Search Weather",
                color = Amber100
            )
        }
    }
}

@Composable
fun WeatherDetails(weather: WeatherResponse) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "${weather.name}, ${weather.sys.country}",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "${weather.main.temp}°C",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = weather.weather.first().description.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            },
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp)) // Add space between each piece of data
        Text(
            text = "Wind: ${weather.wind.speed} m/s",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "Humidity: ${weather.main.humidity}%",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
