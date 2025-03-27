package com.example.discosapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.discosapp.screens.Anadir
import com.example.discosapp.screens.Detalle
import com.example.discosapp.screens.Home


    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "HOME") {
            composable("HOME") {
                Home(
                    navigateToAddDiscos = { navController.navigate("ANADIR") },
                    navigateToDiscosDetails = {
                        val disco : String =""
                        navController.navigate("DETALLE/$disco")
                    }
                )
            }
            composable("ANADIR") {
                Anadir()
            }

            composable("DETALLE/{disco}") {backStackEntry->
                val input = backStackEntry . arguments ?. getString ("input") ?: "Sin valor"
                Detalle(
                    navigateBack = { navController.popBackStack() },
                    disco = input
                )
            }
        }
    }