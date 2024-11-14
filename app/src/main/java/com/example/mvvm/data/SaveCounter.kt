package com.example.mvvm.data

import android.content.Context

class SaveCounter (context: Context) {
    private val preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var counter: Int
        set(value){
            val editor = preference.edit()
            editor?.putInt(COUNTER, value)
            editor?.apply()
        }
        get() = preference.getInt(COUNTER, 0)

    companion object {
        const val PREF_NAME = "data-counter"
        const val  COUNTER = "counter"
    }
}