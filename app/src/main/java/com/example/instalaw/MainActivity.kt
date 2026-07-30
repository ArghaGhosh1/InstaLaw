package com.example.instalaw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.instalaw.LawyersScreen.LawyersScreen
import com.example.instalaw.ui.theme.InstaLawTheme

class ````````````````````````````````````````````````````````````````````````````````````````````````````````.....................`````````````````````````````````````````MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaLawTheme {

                LawyersScreen()
            }
        }
    }
}



