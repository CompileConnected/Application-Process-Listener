package com.ura.appprocess.sample

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.ura.appprocess.api.ApplicationProcessListener

class SampleAppProcessListener : ApplicationProcessListener {

    private companion object {
        val TAG: String = this::class.java.simpleName
    }

    override fun onApplicationStateChanged(
        context: Context,
        state: ApplicationProcessListener.State
    ) {
        val msg = when (state) {
            ApplicationProcessListener.State.BACKGROUND -> "App in background"
            else -> "App in foreground"
        }
        Log.i(TAG, msg)

        //toast might not showing on background android Tiramisu
        //even in application context
        context.showToast(msg)
    }
}


private fun Context.showToast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()