package com.example.instalaw.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instalaw.Presentation.AlreadyHaveAnAccount.AlreadyHaveAnAccount
import com.example.instalaw.Presentation.EntryScreen.EntryScreen
import com.example.instalaw.Presentation.HomeScreen.HomeScreen
import com.example.instalaw.Presentation.LawyersScreen.LawyersScreen
import com.example.instalaw.Presentation.NewUserRegistration.NewUserRegistration

@Composable
fun setUpNavHost(navController : NavHostController){

    NavHost(startDestination = Screen.EntryScreen.route, navController = navController){

        composable(Screen.EntryScreen.route) {

            EntryScreen(navController)
        }

        composable(Screen.AlreadyHaveAnAccount.route) {

            AlreadyHaveAnAccount(navController)
        }

        composable(Screen.LawyersScreen.route) {

            LawyersScreen(navController)
        }

        composable(Screen.HomeScreen.route) {

            HomeScreen(navController)
        }

        composable(Screen.NewUserRegistration.route) {

            NewUserRegistration(navController)
        }

    }
}