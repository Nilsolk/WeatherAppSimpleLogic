package com.example.weatherappsimplelogic

import com.google.gson.annotations.SerializedName

data class WeatherCloud(
//    @SerializedName("time")
//    val time: String,
//    @SerializedName("temperature")
//    val temperature: Float,
    @SerializedName("current_weather")
    val current_weather: Any
) {
    fun toWeather(): Weather {
        return Weather(current_weather)
    }

}

