package com.example.myapplication
import android.app.Application
import android.content.Context

val sharedPreferences: Preferences by lazy {
    App.preferences!!
}

class Preferences(var context: Context) {

}

class App: Application() {

    companion object {
        var preferences: Preferences? = null
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        preferences = Preferences(applicationContext)
    }

}