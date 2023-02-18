package com.example.weatherappsimplelogic

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException


class ConnectionModel(
    private val manageResources: ManageResources,
    private val weatherService: WeatherService
) : Repo<Weather, Error> {
    private var callback: ResultOfConnectionCallback<Weather, Error>? = null
    override fun fetch() {
        weatherService.weather().enqueue(object : Callback<WeatherCloud> {
            override fun onResponse(call: Call<WeatherCloud>, response: Response<WeatherCloud>) {
                if (response.isSuccessful) {
                    callback?.provideSuccess(response.body()!!.toWeather())
                } else {
                    callback?.provideError(Error.ServiceUnavailable(manageResources))
                }
            }

            override fun onFailure(call: Call<WeatherCloud>, t: Throwable) {
                if (t is UnknownHostException || t is java.net.ConnectException) {
                    callback?.provideError(Error.NoConnection(manageResources))
                }
            }

        })
    }

    override fun clear() {
        callback = null
    }

    override fun init(resultOfConnectionCallback: ResultOfConnectionCallback<Weather, Error>) {
        this.callback = resultOfConnectionCallback
    }

}