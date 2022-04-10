package com.ura.appprocess.api

import android.app.Activity
import android.app.Application
import android.os.Bundle

abstract class ApplicationLifeCycleDelegate :
    Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        return
    }

    override fun onActivityStarted(activity: Activity) {
        return
    }

    override fun onActivityResumed(activity: Activity) {
        return
    }

    override fun onActivityPaused(activity: Activity) {
        return
    }

    override fun onActivityStopped(activity: Activity) {
        return
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        return
    }

    override fun onActivityDestroyed(activity: Activity) {
        return
    }
}