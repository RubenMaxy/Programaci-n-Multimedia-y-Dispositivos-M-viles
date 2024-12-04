package com.resuadam2.cartaalta.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.resuadam2.cartaalta.ui.screens.GameOverScreen
import com.resuadam2.cartaalta.ui.screens.GameScreen
import com.resuadam2.cartaalta.ui.screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HOME.name
        )
    {
        composable(AppScreens.HOME.name) {
            HomeScreen(
                onPlay = {
                    navController.navigate(AppScreens.GAME.name)
                }
            )
        }
        composable(
            AppScreens.GAME.name
        ) {
            GameScreen(
                onBackToMenu = { navController.popBackStack() }
            ) {
                navController.navigate(AppScreens.GAME_OVER.name + "/${it}")
            }
        }
        composable(
            AppScreens.GAME_OVER.name+ "/{ganador}",
            arguments = listOf(navArgument("ganador") { type = NavType.StringType }) ) {
            GameOverScreen(
                ganador = it.arguments?.getString("ganador") ?: "Jugador 1",
                onRestart = {
                    navController.popBackStack(AppScreens.HOME.name, false)
                }
            )
        }
    }

}