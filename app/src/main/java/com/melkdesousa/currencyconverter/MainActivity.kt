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

        binding.buttonConvertToDollar.setOnClickListener {
            calcTax(0.8, "US$ %.2f")
        }

        binding.buttonConvertToReal.setOnClickListener {
            calcTax(5.0, "R$ %.2f")
        }

        binding.buttonConvertToPeso.setOnClickListener {
            calcTax(10.2, "$ %.2f")
        }
    }

    private fun calcTax(tax: Double, format: String) {
        val value = binding.editEuros.text.toString().trim()

        if (value.isNotEmpty()) {
            val result = value.toDouble() * tax

            binding.textConvertedValue.text = String.format(format, result)
        }
    }
}