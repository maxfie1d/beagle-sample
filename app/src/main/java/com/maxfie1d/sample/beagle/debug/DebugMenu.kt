package com.maxfie1d.sample.beagle.debug

import android.app.Application
import android.content.Context
import com.pandulapeter.beagle.Beagle
import com.pandulapeter.beagle.common.configuration.Text
import com.pandulapeter.beagle.common.contracts.BeagleListItemContract
import com.pandulapeter.beagle.common.contracts.module.Module
import com.pandulapeter.beagle.modules.SingleSelectionListModule
import com.pandulapeter.beagle.modules.TextInputModule

object DebugMenu {
    fun setup(application: Application) {
        Beagle.initialize(application)

        Beagle.set(
            *ConfigurableStringDefinition.values().map { definition ->
                module(application.applicationContext, definition)
            }.toTypedArray()
        )
    }

    private fun module(
        context: Context,
        definition: ConfigurableStringDefinition
    ): Module<*> = when (definition.type) {
        ConfigurableStringDefinition.Type.ManualInput -> {
            val configurable = definition.create(context)
            TextInputModule(
                text = Text::CharSequence,
                initialValue = configurable.getValue(),
                onValueChanged = configurable::setValue,
                areRealTimeUpdatesEnabled = false
            )
        }
        is ConfigurableStringDefinition.Type.Options -> {
            val configurable = definition.create(context)
            val (options) = definition.type
            val currentValue = configurable.getValue()
            val initialItem = options.find { it.value == currentValue }

            SingleSelectionListModule(
                title = definition.displayName,
                items = options.map { ListItem(it.id, it.value) },
                initiallySelectedItemId = initialItem?.id,
                onSelectionChanged = { option ->
                    if (option != null) {
                        configurable.setValue(option.value)
                    }
                }
            )
        }
    }

    data class ListItem(
        override val id: String,
        val value: String
    ) : BeagleListItemContract {
        override val title: Text = Text.CharSequence(value)
    }
}
