package com.ura.appprocess.internal

import android.app.Activity
import com.ura.appprocess.api.ApplicationProcessListener

internal interface ApplicationProcessManager {
    fun addApplicationProcessListener(vararg applicationProcessListener: ApplicationProcessListener)
    fun removeApplicationProcessListener(vararg applicationProcessListener: ApplicationProcessListener)
    fun notifyState(activity: Activity, state: ApplicationProcessListener.State)

    companion object {
        @JvmStatic
        fun create(): ApplicationProcessManager {
            return ApplicationProcessManagerImpl()
        }
    }
}