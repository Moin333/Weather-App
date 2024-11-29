package com.example.weatherapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    val weatherData = MutableLiveData<WeatherResponse?>()
    val errorMessage = MutableLiveData<String?>()

    init {
        fetchWeather("Pune")
    }

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                Log.d("WeatherViewModel", "Fetching weather for city: $city")
                val response = WeatherRepository.getCurrentWeather(city)

                if (response.isSuccessful) {
                    weatherData.value = response.body() // Use setValue since you're in the main thread
                    Log.d("WeatherViewModel", "Weather fetched successfully: ${response.body()}")
                } else {
                    errorMessage.value = "Error: ${response.message()}"
                    Log.e("WeatherViewModel", "Failed to fetch weather: ${response.message()}")
                }
            } catch (e: Exception) {
                errorMessage.value = "Failed to load weather data: ${e.message}"
                Log.e("WeatherViewModel", "Exception occurred: ${e.localizedMessage}", e)
            }
        }
    }
}
