package com.odds.movie.data

import android.content.Context

class SharePreferenceLocalStorage(private val context: Context) {

    fun insert(data: String) {
        context.getSharedPreferences("movie", Context.MODE_PRIVATE)
            .edit()
            .putString("username", data)
            .apply()
    }

    fun read(): String {
        return context.getSharedPreferences("movie", Context.MODE_PRIVATE)
            .getString("username", "").orEmpty()
    }
}