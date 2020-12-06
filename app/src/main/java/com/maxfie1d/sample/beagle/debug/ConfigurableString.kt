package com.maxfie1d.sample.beagle.debug

import com.maxfie1d.sample.beagle.BuildConfig
import com.maxfie1d.sample.beagle.data.prefs.PersistDataAccessor

class ConfigurableString(
    private val accessor: PersistDataAccessor,
    private val defaultValue: String
) {
    fun getValue(): String = when {
        BuildConfig.DEBUG -> accessor.getValue()
        else -> defaultValue
    }

    fun setValue(value: String) = accessor.setValue(value)
}
