package com.example.weatherappsimplelogic

interface Error {
    fun message(): String

    abstract class ErrorMessage(
        private val manageResources: ManageResources,
        private val messageId: Int
    ) : Error {
        override fun message(): String {
            return manageResources.error(messageId)
        }
    }

    class NoConnection(private val manageResources: ManageResources) :
        ErrorMessage(manageResources, R.string.no_connection_message) {
    }

    class ServiceUnavailable(private val manageResources: ManageResources) :
        ErrorMessage(manageResources, R.string.service_unavailable) {
    }
}
