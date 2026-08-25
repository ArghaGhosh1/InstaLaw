package com.example.instalaw

import android.content.Context

object JwtManager {

    private const val PREF_NAME = "instalaw_auth"
    private const val JWT_KEY = "jwt"

    fun saveToken(context: Context, token: String) {

        context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
            .edit()
            .putString(JWT_KEY, token)
            .apply()
    }

    fun getToken(context: Context): String? {

        return context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
            .getString(JWT_KEY, null)
    }

    fun isLoggedIn(context: Context): Boolean {

        return !getToken(context).isNullOrBlank()
    }

    fun clearToken(context: Context) {

        context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
            .edit()
            .remove(JWT_KEY)
            .apply()
    }
}