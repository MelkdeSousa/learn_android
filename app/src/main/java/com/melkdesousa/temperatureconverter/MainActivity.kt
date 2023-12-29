package com.melkdesousa.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melkdesousa.temperatureconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConvert.setOnClickListener {
            val celsiusText = binding.editCelsius.text

            if (celsiusText.isNotEmpty()) {
                val celsius = celsiusText.toString().toDouble()
                val fahrenheit = String.format("%.2f °F", celsius * 1.8 + 32)

                binding.textResult.text = fahrenheit
            }
        }
    }
}