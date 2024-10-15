package com.example.weatherapp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherRepository {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val API_KEY = "1c76e0f1ec4e92381cbafc3a4547197c" // Move this to a safer place

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val weatherService = retrofit.create(WeatherService::class.java)

    suspend fun getCurrentWeather(city: String): Response<WeatherResponse> {
        return weatherService.getCurrentWeather(city, API_KEY)
    }
}
