package com.melkdesousa.menurestaurant

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.melkdesousa.menurestaurant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val coffeePrice = 5.0
    private val breadPrice = 0.75
    private val chocolatePrice = 7.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFinishOrder.setOnClickListener {
            val i = Intent(this, OrderActivity::class.java)

            i.putExtra("coffee_quantity", binding.editCoffeeQuantity.text.toString())
            i.putExtra("bread_quantity", binding.editBreadQuantity.text.toString())
            i.putExtra("chocolate_quantity", binding.editChocolateQuantity.text.toString())
            i.putExtra("coffee_price", coffeePrice)
            i.putExtra("bread_price", breadPrice)
            i.putExtra("chocolate_price", chocolatePrice)

            startActivity(i)
        }

        binding.checkCoffee.setOnClickListener {
            if (!binding.checkCoffee.isChecked) {
                binding.editCoffeeQuantity.setText("0")
                binding.textCoffeePrice.visibility = View.GONE

                return@setOnClickListener
            }

            binding.editCoffeeQuantity.setText("1")
            binding.textCoffeePrice.text = "R$ $coffeePrice"
            binding.textCoffeePrice.visibility = View.VISIBLE
        }

        binding.checkBread.setOnClickListener {
            if (!binding.checkBread.isChecked) {
                binding.editBreadQuantity.setText("0")
                binding.textBreadPrice.visibility = View.GONE

                return@setOnClickListener
            }

            binding.editBreadQuantity.setText("1")
            binding.textBreadPrice.text = "R$ $breadPrice"
            binding.textBreadPrice.visibility = View.VISIBLE
        }

        binding.checkChocolate.setOnClickListener {
            if (!binding.checkChocolate.isChecked) {
                binding.editChocolateQuantity.setText("0")
                binding.textChocolatePrice.visibility = View.GONE

                return@setOnClickListener
            }

            binding.editChocolateQuantity.setText("1")
            binding.textChocolatePrice.text = "R$ $chocolatePrice"
            binding.textChocolatePrice.visibility = View.VISIBLE
        }
    }
}