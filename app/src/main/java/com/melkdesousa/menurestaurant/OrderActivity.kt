package com.melkdesousa.menurestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melkdesousa.menurestaurant.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val coffeeQuantity = i.getStringExtra("coffee_quantity").toString().toInt()
        val breadQuantity = i.getStringExtra("bread_quantity").toString().toInt()
        val chocolateQuantity = i.getStringExtra("chocolate_quantity").toString().toInt()
        val coffeePrice = i.getDoubleExtra("coffee_price", 0.0)
        val breadPrice = i.getDoubleExtra("bread_price", 0.0)
        val chocolatePrice = i.getDoubleExtra("chocolate_price", 0.0)

        val orderResumeText = "Resumo do pedido: \n" +
                "Café: $coffeeQuantity Preço: ${String.format("R$ %.2f", coffeeQuantity * coffeePrice)}\n" +
                "Pão: $breadQuantity Preço: ${String.format("R$ %.2f", breadQuantity * breadPrice)}\n" +
                "Café: $chocolateQuantity Preço: ${String.format("R$ %.2f", chocolateQuantity * chocolatePrice)}\n";

        binding.textOrderResume.text = orderResumeText
    }
}