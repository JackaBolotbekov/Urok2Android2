package com.example.noteapp.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    private lateinit var sharedPreference: SharedPreferences

    fun unit(context: Context) {
        sharedPreference = context.getSharedPreferences("geek", Context.MODE_PRIVATE)
    }

    var showOnBoard: Boolean
        get () = sharedPreference.getBoolean("tech", false)
        set (value) = sharedPreference.edit().putBoolean("tech", value).apply()
}