package com.example.myapplication.auth

import com.example.myapplication.auth.model.User
import kotlin.math.log

object UserRepository {
    private var user = User("user", "123456")

    fun createUser(user: User) {
        this.user = user
    }

    fun checkUser(user: User): Boolean {
        val loginCondition = user.login == this.user.login
        var passwordCondition = user.password == this.user.password
        return loginCondition && passwordCondition
    }
}