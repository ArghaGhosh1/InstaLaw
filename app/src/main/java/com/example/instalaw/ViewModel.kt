package com.example.instalaw.Presentation.HomeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instalaw.RetrofitInstance
import com.example.instalaw.model.AIRequest
import kotlinx.coroutines.launch

class AIViewModel : ViewModel() {

    var answer by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun askQuestion(question: String) {

        if (question.isBlank()) return

        viewModelScope.launch {

            isLoading = true
            errorMessage = ""
            answer = ""

            try {

                val response = RetrofitInstance.api.askAI(
                    AIRequest(question)
                )

                answer = response.answer

            } catch (e: Exception) {

                errorMessage = e.message ?: "Something went wrong"

            } finally {

                isLoading = false

            }
        }
    }
}