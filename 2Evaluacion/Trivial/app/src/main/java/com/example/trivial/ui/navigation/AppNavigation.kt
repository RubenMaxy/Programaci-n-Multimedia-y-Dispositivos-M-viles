package com.example.trivial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trivial.ui.screens.EndGame
import com.example.trivial.ui.screens.Game
import com.example.trivial.ui.screens.Home
import com.example.trivial.ui.state.TrivialViewModel

@Composable
fun AppNavigation() {
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.GAME.name){
        composable (AppScreens.HOME.name) {
            val viewModel = viewModel<TrivialViewModel>()
            Home(
                navigateToGame = {numQuestions->
                    viewModel.setNumberQuestions(numQuestions)
                    navController.navigate("${AppScreens.GAME.name}/${numQuestions}")}
            )
        }

        composable ( route = AppScreens.GAME.name,
            arguments = listOf(navArgument("numQuestions") { type = NavType.IntType }) ) {
            backStackEntry ->
            val numQuestions = backStackEntry.arguments?.getInt("numQuestions") ?: 5
            Game (
                navigateToEndGame = {
                    navController.navigate("${AppScreens.ENDGAME.name}/${numQuestions}"){
                        popUpTo(AppScreens.GAME.name) { inclusive = true }
                    }},
                numQuestions=numQuestions
            )
        }

        composable ( route = AppScreens.ENDGAME.name,
            arguments = listOf(navArgument("points") { type = NavType.FloatType})) {
                backStackEntry ->
            val points = backStackEntry.arguments?.getFloat("points")?.toDouble() ?: 0.0
            EndGame(
                navigateToHome = {
                    navController.navigate(AppScreens.HOME.name) {
                        popUpTo(AppScreens.ENDGAME.name) { inclusive = true }
                    }
                },
                points = points
            )
        }

    }
}