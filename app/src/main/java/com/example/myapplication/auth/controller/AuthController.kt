package com.example.myapplication.auth.controller
import android.content.Context
import com.example.myapplication.auth.UserRepository
import com.example.myapplication.auth.model.User

interface IAuth {
    fun signIn(login: String, password: String): Boolean
    fun signUp(login: String, password: String): Boolean
}

class AuthController(): IAuth {
    //ЛОГИН
    override fun signIn(login: String, password: String): Boolean {
        val user = User(login, password)
        return UserRepository.checkUser(user)
    }

    //РЕГИСТРАЦИЯ
    override fun signUp(login: String, password: String): Boolean {
        val user = User(login, password)
        if (validateUser(user)) {
            UserRepository.createUser(user)
            return true
        } else {
            return false
        }
    }

    private fun validateUser(user: User): Boolean {
        return user.login != "" && user.password.count() >= 6
    }

}