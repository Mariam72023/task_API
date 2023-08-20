package com.example.myapi.data.presestance.sharedpref

import android.content.Context
import com.example.myapi.presentation.MyApplication


class AppSharedPref() {
    val sharedPref = MyApplication.context
        .getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = sharedPref.edit()
        editor.putString("token", token)
        editor.apply()
    }
    fun getToken():String?{
      return  sharedPref.getString("token",null)

    }
}