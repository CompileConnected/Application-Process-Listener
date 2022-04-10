package com.ura.appprocess.api

import android.app.Application
import com.ura.appprocess.internal.ApplicationProcessManager
import com.ura.appprocess.internal.ApplicationProcessManagerLifecycleDelegate

class ApplicationProcess(builder: Builder) {

    private val applicationLifeCycle: Application.ActivityLifecycleCallbacks =
        builder.applicationLifeCycle!!

    fun registerToApplication(app: Application) {
        app.registerActivityLifecycleCallbacks(applicationLifeCycle)
    }

    fun removeFromApplication(app: Application) {
        app.unregisterActivityLifecycleCallbacks(applicationLifeCycle)
    }

    sealed interface Builder {

        var applicationLifeCycle: Application.ActivityLifecycleCallbacks?

        /**
         * Default ApplicationProcess Builder
         */
        class Default : Builder {
            override var applicationLifeCycle: Application.ActivityLifecycleCallbacks? = null

            private val listenerList: ArrayList<ApplicationProcessListener> = arrayListOf()

            fun add(applicationProcessListener: ApplicationProcessListener) = apply {
                listenerList.add(applicationProcessListener)
            }

            fun add(list: List<ApplicationProcessListener>) = apply {
                listenerList.addAll(list)
            }

            fun build(): ApplicationProcess {
                applicationLifeCycle = ApplicationProcessManagerLifecycleDelegate(
                    ApplicationProcessManager.create().apply {
                        addApplicationProcessListener(*listenerList.toTypedArray())
                    })
                return ApplicationProcess(this)
            }
        }
    }
}