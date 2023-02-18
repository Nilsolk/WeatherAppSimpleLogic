package com.example.weatherappsimplelogic

import retrofit2.Call
import retrofit2.http.GET

interface WeatherService {
    @GET("https://api.open-meteo.com/v1/forecast?latitude=54.33&longitude=48.39&hourly=temperature_2m,windspeed_10m&current_weather=true&timezone=Europe%2FMoscow&past_days=1")
    fun weather(): Call<WeatherCloud>
}
