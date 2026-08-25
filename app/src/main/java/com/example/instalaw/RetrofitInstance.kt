package com.example.instalaw

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private lateinit var appContext: Context

    fun initialize(context: Context) {
        appContext = context.applicationContext
    }

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()

        .connectTimeout(300, TimeUnit.SECONDS)
        .readTimeout(300, TimeUnit.SECONDS)
        .writeTimeout(300, TimeUnit.SECONDS)

        .addInterceptor { chain ->

            val originalRequest = chain.request()

            val path = originalRequest.url.encodedPath

            // These endpoints are PUBLIC
            val isPublicEndpoint =
                path == "/public/signUp" ||
                        path == "/public/logIn"

            if (isPublicEndpoint) {

                // Don't attach JWT
                chain.proceed(originalRequest)

            } else {

                // Protected endpoints
                val token = JwtManager.getToken(appContext)

                val request = originalRequest
                    .newBuilder()

                if (!token.isNullOrBlank()) {

                    request.addHeader(
                        "Authorization",
                        "Bearer $token"
                    )
                }

                chain.proceed(request.build())
            }
        }

        .addInterceptor(logging)
        .build()

    private val retrofit by lazy {

        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}