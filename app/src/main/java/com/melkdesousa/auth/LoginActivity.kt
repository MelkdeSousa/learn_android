package com.melkdesousa.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.melkdesousa.auth.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editNickname = binding.editNickname
        val editPassword = binding.editPassword
        val buttonEnter = binding.buttonEnter

        buttonEnter.setOnClickListener {
            val nickname = editNickname.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (nickname == "user" && password == "pass") {
                startActivity(Intent(this, HomeActivity::class.java))
                return@setOnClickListener
            }

            Toast.makeText(applicationContext, "Login inválido!", Toast.LENGTH_SHORT).show()
        }
    }
}