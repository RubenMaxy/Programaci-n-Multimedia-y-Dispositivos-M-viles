package com.example.trivial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivial.ui.screens.EndGame
import com.example.trivial.ui.screens.Game
import com.example.trivial.ui.screens.Home

@Composable
fun AppNavigation() {
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.GAME.name){
        composable (AppScreens.HOME.name) {
            Home(
                navigateToGame = {navController.navigate(AppScreens.GAME.name)}
            )
        }

        composable (AppScreens.GAME.name) {
            Game (
                navigateToEndGame = {
                    navController.navigate(AppScreens.ENDGAME.name){
                        popUpTo(AppScreens.GAME.name) { inclusive = true }
                    }
                }
            )
        }

        composable (AppScreens.ENDGAME.name) {
            EndGame (
                navigateToHome = {
                    navController.navigate(AppScreens.HOME.name){
                        popUpTo(AppScreens.ENDGAME.name) { inclusive = true }
                    }
                }
            )
        }

    }
}