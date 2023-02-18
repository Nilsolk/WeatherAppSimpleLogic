package com.example.weatherappsimplelogic

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApp : Application() {
    lateinit var viewModel: WeatherViewModel
    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.google.com/")
            .build()
        viewModel = WeatherViewModel(
            ConnectionModel(
                ManageResources.Base(this),
                retrofit.create(WeatherService::class.java)
            )
        )
    }
}