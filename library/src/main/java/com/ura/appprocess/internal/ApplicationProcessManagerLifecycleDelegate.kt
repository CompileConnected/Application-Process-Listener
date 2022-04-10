package com.ura.appprocess.internal

import android.app.Activity
import com.ura.appprocess.api.ApplicationLifeCycleDelegate
import com.ura.appprocess.api.ApplicationProcessListener


internal class ApplicationProcessManagerLifecycleDelegate(private val applicationProcessManager: ApplicationProcessManager) :
    ApplicationLifeCycleDelegate() {

    private var activityCount = 0

    private val isAppBackground: Boolean
        get() = activityCount > 0

    override fun onActivityStarted(activity: Activity) {
        if (!isAppBackground) {
            applicationProcessManager.notifyState(
                activity,
                ApplicationProcessListener.State.FOREGROUND
            )
            activityCount = 0
        }
        activityCount++
    }

    override fun onActivityStopped(activity: Activity) {
        activityCount--
        if (!isAppBackground) {
            applicationProcessManager.notifyState(
                activity,
                ApplicationProcessListener.State.BACKGROUND
            )
            activityCount = 0
        }
    }
}