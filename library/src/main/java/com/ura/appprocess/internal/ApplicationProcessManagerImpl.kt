package com.ura.appprocess.internal

import android.app.Activity
import com.ura.appprocess.api.ApplicationProcessListener

internal class ApplicationProcessManagerImpl : ApplicationProcessManager {
    private val applicationProcessListenerList: ArrayList<ApplicationProcessListener> =
        arrayListOf()

    override fun addApplicationProcessListener(vararg applicationProcessListener: ApplicationProcessListener) {
        applicationProcessListenerList.addAll(applicationProcessListener)
    }

    override fun removeApplicationProcessListener(vararg applicationProcessListener: ApplicationProcessListener) {
        applicationProcessListenerList.removeAll(applicationProcessListener)
    }

    override fun notifyState(activity: Activity, state: ApplicationProcessListener.State) {
        applicationProcessListenerList.forEach {
            it.onApplicationStateChanged(activity.applicationContext, state)
        }
    }
}