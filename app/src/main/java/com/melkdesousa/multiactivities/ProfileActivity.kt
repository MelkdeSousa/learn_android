package com.melkdesousa.multiactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.melkdesousa.multiactivities.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonGoBack = binding.buttonGoBack

        buttonGoBack.setOnClickListener {
            finish()
        }
    }
}