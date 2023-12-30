package com.melkdesousa.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.melkdesousa.auth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editNickname = binding.editNickname
        val editPassword = binding.editPassword
        val buttonEnter = binding.buttonEnter

        buttonEnter.setOnClickListener {
            val nickname = editNickname.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (nickname == "user" && password == "pass") {
                Toast.makeText(applicationContext, "Login válido!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(applicationContext, "Login inválido!", Toast.LENGTH_SHORT).show()
        }
    }
}