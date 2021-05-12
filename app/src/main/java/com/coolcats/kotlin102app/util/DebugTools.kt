package com.coolcats.kotlin102app.util

import android.util.Log

class DebugTools {
    companion object {
        fun logThis(message: String) {
            Log.d("Meow",message)
        }
    }
}