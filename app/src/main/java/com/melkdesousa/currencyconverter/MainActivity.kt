package com.melkdesousa.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melkdesousa.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConvert.setOnClickListener {
            val euros = binding.editEuros.text.toString().trim()

            if (euros.isNotEmpty()) {
                val dollars = euros.toDouble() * 0.8

                binding.textDollars.text = String.format("US$ %.2f", dollars)
            }
        }
    }
}