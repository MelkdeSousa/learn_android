package com.melkdesousa.listusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.melkdesousa.listusers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var userAdapter: ArrayAdapter<User>
    private var positionItem  = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editUsername = binding.editUsername
        val editPassword = binding.editPassword
        val listViewUser = binding.listViewUsers

        val users = arrayListOf<User>(User("melkdesousa", "melk321"), User("jao", "jaj123"))

        userAdapter = ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users)

        listViewUser.adapter = userAdapter

        listViewUser.setOnItemClickListener { _, _, position, _ ->
            val (username, password) = users[position]

            editUsername.setText(username)
            editPassword.setText(password)

            positionItem = position
        }

        binding.buttonAddUser.setOnClickListener {
            val user = getFormValues()

            if (user.username.isNotEmpty() && user.password.isNotEmpty()) {
                users.add(user)

                updateListView()
            }
        }

        binding.buttonEditUser.setOnClickListener {
            if (positionItem < 0) return@setOnClickListener

            val (username, password) = getFormValues()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                users[positionItem].username = username
                users[positionItem].password = password

                updateListView()
            }
        }

        binding.buttonRemoveUser.setOnClickListener {
            if (positionItem < 0) return@setOnClickListener

            users.removeAt(positionItem)
            updateListView()
        }

        binding.buttonClear.setOnClickListener {
            users.clear()

            updateListView()
        }
    }

    private fun getFormValues(): User {
        val username = binding.editUsername.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()

        return User(username, password)
    }

    private fun updateListView() {
        userAdapter.notifyDataSetChanged()

        binding.editUsername.setText("")
        binding.editPassword.setText("")
        positionItem = -1
    }
}