package com.maxfie1d.sample.beagle.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.pandulapeter.beagle.Beagle

class MainActivityViewModel() : ViewModel() {
    fun openDebugMenu() {
        Beagle.show()
    }
}
