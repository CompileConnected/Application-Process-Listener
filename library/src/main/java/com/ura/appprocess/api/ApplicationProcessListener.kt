package com.ura.appprocess.api

import android.content.Context

interface ApplicationProcessListener {
    enum class State {
        BACKGROUND,
        FOREGROUND
    }
    fun onApplicationStateChanged(context: Context, state: State)
}