package com.example.instalaw

import com.example.instalaw.model.postResponseItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("public/signUp")
    suspend fun post(
        @Body post: postResponseItem
    ): Response<postResponseItem>
}