package com.example.instalaw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.instalaw.Navigation.setUpNavHost
import com.example.instalaw.Presentation.NewUserRegistration.NewUserRegistration
import com.example.instalaw.ui.theme.InstaLawTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaLawTheme {

                navController = rememberNavController()
                setUpNavHost(navController as NavHostController)

            }
        }
    }
}



