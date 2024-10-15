package com.example.weatherapp

data class WeatherResponse(
    val main: Main,
    val weather: List<WeatherCondition>,
    val wind: Wind,
    val dt: Long,
    val name: String,
    val sys: Sys
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val humidity: Int
)

data class WeatherCondition(
    val description: String,
    val icon: String
)

data class Wind(
    val speed: Double,
    val deg: Int
)

data class Sys(
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
