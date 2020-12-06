package com.maxfie1d.sample.beagle.debug

import android.content.Context
import com.maxfie1d.sample.beagle.BuildConfig
import com.maxfie1d.sample.beagle.data.prefs.DataProps
import com.maxfie1d.sample.beagle.data.prefs.PersistDataAccessor

enum class ConfigurableStringDefinition(
    val displayName: String,
    val type: Type,
    private val props: DataProps,
    private val defaultValue: String
) {
    API_HOST(
        "APIホスト",
        Type.Options(
            listOf(
                Option("dev", "dev.api.example.com"),
                Option("qa", "qa.api.example.com"),
                Option("prod", "api.example.com"),
            )
        ),
        DataProps.API_HOST,
        BuildConfig.API_HOST
    ),
    USER_ID(
        "ユーザーID",
        Type.ManualInput,
        DataProps.USER_ID,
        "user_id"
    );

    sealed class Type {
        object ManualInput : Type()
        data class Options(val options: List<Option>) : Type()
    }

    data class Option(val id: String, val value: String)

    fun create(context: Context): ConfigurableString =
        ConfigurableString(PersistDataAccessor(context, props), defaultValue)
}
