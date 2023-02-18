package com.example.weatherappsimplelogic

import android.content.Context
import androidx.annotation.StringRes

interface ManageResources {
    fun error(@StringRes resourceId: Int): String

    class Base(private val context: Context) : ManageResources {
        override fun error(resourceId: Int): String {
            return context.getString(resourceId)
        }

    }
}
