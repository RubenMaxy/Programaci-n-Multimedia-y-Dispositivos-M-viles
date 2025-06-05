package com.example.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.starwars.ui.screens.FavoritosScreen
import com.example.starwars.ui.screens.ListaCompletaScreen
import com.example.starwars.ui.screens.ScreenPrincipal
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Principal.route) {
        composable(Screens.Principal.route) { ScreenPrincipal(navController) }
        composable(Screens.ListaCompleta.route) { ListaCompletaScreen() }
        composable(Screens.Favoritos.route) { FavoritosScreen() }
    }
}
