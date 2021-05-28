package com.example.myapplication.auth.model

class User {
    var login: String
    var password: String

    constructor(login: String, password: String) {
        this.login = login
        this.password = password
    }
}