package com.melkdesousa.intentpower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.melkdesousa.intentpower.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>

    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonToChangeName = binding.buttonToChangeName

        buttonToChangeName.setOnClickListener {
            val i = Intent(this, SecondaryActivity::class.java)
            i.putExtra("name", name)
            result.launch(i)
        }

        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data == null) {
                Toast.makeText(applicationContext, "Erro ao atualizar o nome!", Toast.LENGTH_SHORT)
                    .show()

                return@registerForActivityResult
            }

            when (it.resultCode) {
                1 -> {
                    name = it.data?.getStringExtra("name").toString()
                    binding.textMessage.setText("Olá $name")
                }

                2 ->
                    Toast.makeText(applicationContext, "Operação cancelada.", Toast.LENGTH_SHORT)
                        .show()

            }
        }
    }
}