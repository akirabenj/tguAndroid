package com.example.myapplication.auth

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.auth.model.User
import kotlin.math.log

object UserRepository {
    private var user = User("user", "123456")

    fun createUser(user: User) {
        this.user = user
        //setUser()
    }

    fun checkUser(user: User): Boolean {
        //val storedUser = getUser()
        val loginCondition = user.login == this.user.login
        var passwordCondition = user.password == this.user.password
        return loginCondition && passwordCondition
    }
}
    /*private fun setUser() {
        val sharedPreferences = context?.getSharedPreferences("userStorage", Context.MODE_PRIVATE)
        sharedPreferences?.edit()?.putString("login", this.user.login)
        sharedPreferences?.edit()?.putString("password", this.user.password)
        sharedPreferences?.edit()?.commit()
        println(sharedPreferences?.getString("login", null))
    }

    private fun getUser(): User {
        val sharedPreferences = context?.getSharedPreferences("userStorage",Context.MODE_PRIVATE)
        val loginO = sharedPreferences?.getString("login", null)
        val passwordO = sharedPreferences?.getString("password", null)

        println(loginO)
        println(passwordO)

        var login = ""
        var password = ""

        loginO?.let {
            login = it
        }
        passwordO?.let {
            password = it
        }
        return User(login, password)
    }*/