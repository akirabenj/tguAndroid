package com.example.myapplication.auth

import com.example.myapplication.auth.model.User

object UserRepository {
    private var user = User("user", "123456")

    fun createUser(user: User) {
        this.user = user
    }

    fun checkUser(user: User): Boolean {
        return this.user == user
    }
}