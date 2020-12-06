package com.maxfie1d.sample.beagle

import android.app.Application
import com.maxfie1d.sample.beagle.debug.DebugMenu

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DebugMenu.setup(this)
    }
}
