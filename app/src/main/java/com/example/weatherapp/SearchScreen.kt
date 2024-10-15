package com.example.weatherapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.ui.theme.Amber
import com.example.weatherapp.ui.theme.Amber100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: WeatherViewModel, navController: NavController) {
    var city by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Search Weather", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text(text = "Enter city name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Fetch the weather for the city entered by the user
                viewModel.fetchWeather(city)
                // Navigate back to HomeScreen
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Get Weather",
                color = Amber100
            )
        }
    }
}
