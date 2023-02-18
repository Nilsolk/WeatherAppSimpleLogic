package com.example.weatherappsimplelogic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherappsimplelogic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (application as WeatherApp).viewModel
        binding.refreshButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.refreshButton.isClickable = false
            viewModel.giveText()
        }
        viewModel.init(object : TextCallback {
            override fun provideText(text: String) {
                binding.weatherInfo.text = text
                binding.progressBar.visibility = View.INVISIBLE
                binding.refreshButton.isClickable = true
            }

        })

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}