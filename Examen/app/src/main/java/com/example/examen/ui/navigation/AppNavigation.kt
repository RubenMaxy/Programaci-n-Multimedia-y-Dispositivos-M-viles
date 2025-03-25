package com.example.examen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen.ui.screens.Pantalla1
import com.example.examen.ui.screens.Pantalla2


    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "pantalla1") {
            composable("pantalla1") {
                Pantalla1 { userInput ->
                    navController.navigate("pantalla2/$userInput")
                }
            }
            composable("pantalla2/{input}") { backStackEntry ->
                val input = backStackEntry.arguments?.getString("input") ?: "Sin valor"
                Pantalla2(input)
            }
        }
    }