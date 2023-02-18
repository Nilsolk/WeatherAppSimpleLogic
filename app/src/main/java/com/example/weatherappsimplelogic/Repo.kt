package com.example.weatherappsimplelogic

interface Repo<S, E> {
    fun fetch()
    fun clear()
    fun init(resultOfConnectionCallback: ResultOfConnectionCallback<S, E>)
}

interface ResultOfConnectionCallback<S, E> {
    fun provideSuccess(data: S)
    fun provideError(error: E)
}
