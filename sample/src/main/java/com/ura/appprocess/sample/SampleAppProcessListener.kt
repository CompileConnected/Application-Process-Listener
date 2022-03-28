package com.ura.appprocess.sample

import android.content.Context
import android.widget.Toast
import com.ura.appprocess.api.ApplicationProcessListener

class SampleAppProcessListener : ApplicationProcessListener {
    override fun onApplicationStateChanged(
        context: Context,
        state: ApplicationProcessListener.State
    ) {
        val msg = when (state) {
            ApplicationProcessListener.State.BACKGROUND -> "App in background"
            else -> "App in foreground"
        }
        context.showToast(msg)
    }
}


private fun Context.showToast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()