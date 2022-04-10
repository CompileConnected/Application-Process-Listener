package com.ura.appprocess.sample

import android.app.Application
import com.ura.appprocess.api.ApplicationProcess

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val applicationProcess = ApplicationProcess.Builder.Default()
            .add(SampleAppProcessListener())
            .build()

        applicationProcess.registerToApplication(this)
    }
}