package com.example.instalaw.Presentation.AlreadyHaveAnAccount

import LoginRequest
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instalaw.JwtManager
import com.example.instalaw.RetrofitInstance
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun login(
        context: Context,
        username: String,
        password: String,
        onSuccess: () -> Unit
    ) {

        viewModelScope.launch {

            isLoading = true
            errorMessage = ""

            try {

                val response = RetrofitInstance.api.login(
                    LoginRequest(
                        username = username,
                        password = password
                    )
                )

                if (response.isSuccessful) {

                    // LoginResponse object
                    val loginResponse = response.body()

                    // Get JWT from the object
                    val jwt = loginResponse?.token

                    if (!jwt.isNullOrBlank()) {

                        println("JWT RECEIVED: $jwt")

                        // Save JWT
                        JwtManager.saveToken(
                            context,
                            jwt
                        )

                        // Login successful
                        onSuccess()

                    } else {

                        errorMessage = "JWT token is empty"
                    }

                } else {

                    errorMessage =
                        "Login failed: HTTP ${response.code()}"

                }

            } catch (e: Exception) {

                e.printStackTrace()

                errorMessage =
                    e.message ?: "Unable to connect to server"

            } finally {

                isLoading = false
            }
        }
    }
}