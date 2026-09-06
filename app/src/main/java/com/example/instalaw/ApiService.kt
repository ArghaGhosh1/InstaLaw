package com.example.instalaw

import LoginRequest
import com.example.instalaw.model.AIRequest
import com.example.instalaw.model.AIResponse
import com.example.instalaw.model.LoginResponse
import com.example.instalaw.model.postResponseItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("public/signUp")
    suspend fun post(@Body post: postResponseItem): Response<postResponseItem>

    @POST("ai/ask")
    suspend fun askAI(@Body request: AIRequest): AIResponse

    @POST("public/logIn")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}