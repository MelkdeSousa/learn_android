package com.melkdesousa.intentpower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melkdesousa.intentpower.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val name = i.extras?.getString("name")

        binding.editName.setText(name)

        binding.buttonChangeName.setOnClickListener {
            i.putExtra("name", binding.editName.text.toString())
            setResult(1, i)
            finish()
        }

        binding.buttonCancel.setOnClickListener {
            setResult(2, i)
            finish()
        }
    }
}