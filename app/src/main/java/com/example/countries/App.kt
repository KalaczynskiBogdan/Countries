package com.example.countries

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class App : Application() {
    companion object {
        lateinit var sharedPreferences: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = this.getSharedPreferences("list", Context.MODE_PRIVATE)
    }
}