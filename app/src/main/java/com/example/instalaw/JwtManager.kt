package com.example.instalaw

import android.content.Context
import android.util.Base64
import org.json.JSONObject

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

    fun isTokenExpired(token: String): Boolean {

        return try {

            val parts = token.split(".")

            if (parts.size != 3) {
                return true
            }

            val payload = parts[1]

            val decodedBytes = Base64.decode(
                payload,
                Base64.URL_SAFE or Base64.NO_WRAP or Base64.NO_PADDING
            )

            val payloadJson = JSONObject(
                String(decodedBytes, Charsets.UTF_8)
            )

            val expirationTime = payloadJson.getLong("exp")

            val currentTime = System.currentTimeMillis() / 1000

            currentTime >= expirationTime

        } catch (e: Exception) {

            true
        }
    }

    fun isLoggedIn(context: Context): Boolean {

        val token = getToken(context)

        if (token.isNullOrBlank()) {
            return false
        }

        if (isTokenExpired(token)) {

            clearToken(context)

            return false
        }

        return true
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