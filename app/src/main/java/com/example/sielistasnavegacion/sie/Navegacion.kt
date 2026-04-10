package com.example.sielistasnavegacion.sie

import com.example.listaspeoductos.sie.screens.LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(navController)
        }

    }
}