package com.maxfie1d.sample.beagle.data.prefs

import android.content.Context

class PersistDataAccessor(
    context: Context,
    private val props: DataProps
) {
    private val prefs = context.getSharedPreferences("debug_menu", Context.MODE_PRIVATE)

    fun getValue(): String = prefs.getString(props.key, props.defaultValue)!!

    fun setValue(value: String) = prefs.edit().putString(props.key, value).apply()
}

enum class DataProps(
    val key: String,
    val defaultValue: String
) {
    API_HOST(
        key = "api_host",
        defaultValue = ""
    ),
    USER_ID(
        key = "user_id",
        defaultValue = ""
    )
}
