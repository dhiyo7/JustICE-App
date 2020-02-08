package com.jadwal.justiceapp.utilities

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.provider.Settings.Global.putString

class JusticeUtils {
    companion object {
        var API_ENDPOINT = "http://juice-apps.herokuapp.com/"

        fun getToken(c : Context) : String {
            val s = c.getSharedPreferences("USER", MODE_PRIVATE)
            val token = s?.getString("TOKEN", "UNDIFINED")
            return token!!
        }

        fun setToken(context: Context, token : String){
            val pref = context.getSharedPreferences("USER", MODE_PRIVATE)
            pref.edit().apply{
                putString("TOKEN", token)
                apply()
            }
        }

        fun clearToken(context: Context){
            val pref = context.getSharedPreferences("USER", MODE_PRIVATE)
            pref.edit().clear().apply()
        }
    }
}