package com.example.instalaw.Navigation

sealed class Screen(var route: String) {

    object EntryScreen : Screen("EntryScreen")
    object NewUserRegistration : Screen("NewUserRegistration")
    object HomeScreen : Screen("HomeScreen")
    object LawyersScreen : Screen("LawyersScreen")
    object AlreadyHaveAnAccount : Screen("AlreadyHaveAnAccount")
}