package com.example.weatherappsimplelogic

class Weather(
//    private val time: String,
//    private val temperature: Float,
    private val windSpeed: Any
) {
    fun weatherToUi() =
//        "time : $time\ntemperature: $temperature\nWind speed: $windSpeed"
        "$windSpeed"
}