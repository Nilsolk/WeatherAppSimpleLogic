package com.example.weatherappsimplelogic

class WeatherViewModel(private val model: Repo<Weather, Error>) : UiCallback {
    private var callback = TextCallback.Empty()
    override fun giveText() {
        model.fetch()
    }

    override fun init(callback: TextCallback) {
        model.init(object : ResultOfConnectionCallback<Weather, Error> {
            override fun provideSuccess(data: Weather) {
                callback.provideText(data.weatherToUi())
            }

            override fun provideError(error: Error) {
                callback.provideText(error.message())
            }

        })
    }

    override fun clear() {
        callback = TextCallback.Empty()
        model.clear()
    }
}

interface TextCallback {
    fun provideText(text: String)
    class Empty : TextCallback {
        override fun provideText(text: String) = Unit
    }
}

interface UiCallback {
    fun giveText() {}
    fun init(callback: TextCallback) {}
    fun clear() {}

}