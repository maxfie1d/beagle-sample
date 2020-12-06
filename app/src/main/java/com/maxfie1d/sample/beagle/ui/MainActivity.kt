package com.maxfie1d.sample.beagle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.maxfie1d.sample.beagle.R
import com.maxfie1d.sample.beagle.databinding.ActivityMainBinding
import com.maxfie1d.sample.beagle.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater).also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }
        setContentView(binding.root)
    }
}
