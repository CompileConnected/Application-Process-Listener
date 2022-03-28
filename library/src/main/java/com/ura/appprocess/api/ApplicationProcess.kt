package com.ura.appprocess.api

import android.app.Application
import com.ura.appprocess.internal.ApplicationProcessManager
import com.ura.appprocess.internal.ApplicationProcessManagerLifecycleDelegate

class ApplicationProcess(builder: Builder) {

    private val applicationProcessManager =
        ApplicationProcessManager.create().apply {
            addApplicationProcessListener(*builder.listenerList.toTypedArray())
        }

    private val applicationProcessManagerLifecycleDelegate =
        ApplicationProcessManagerLifecycleDelegate(applicationProcessManager)

    fun registerToApplication(app: Application) {
        app.registerActivityLifecycleCallbacks(applicationProcessManagerLifecycleDelegate)
    }

    fun removeFromApplication(app: Application) {
        app.unregisterActivityLifecycleCallbacks(applicationProcessManagerLifecycleDelegate)
    }

    class Builder {
        val listenerList: ArrayList<ApplicationProcessListener> = arrayListOf()

        fun add(applicationProcessListener: ApplicationProcessListener) = apply {
            listenerList.add(applicationProcessListener)
        }

        fun add(list: List<ApplicationProcessListener>) = apply {
            listenerList.addAll(list)
        }

        fun build() = ApplicationProcess(this)
    }
}