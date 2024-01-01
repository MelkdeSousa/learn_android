package com.melkdesousa.listusers

data class User(var username: String, var password: String){
    override fun toString(): String {
        return username
    }
}
