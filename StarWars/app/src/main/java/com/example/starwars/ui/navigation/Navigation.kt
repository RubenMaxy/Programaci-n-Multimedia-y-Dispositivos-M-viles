package com.example.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.example.starwars.ui.screens.FavoritosScreen
import com.example.starwars.ui.screens.ListaCompletaScreen
import com.example.starwars.ui.screens.ScreenPrincipal
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.screens.DetallesScreen


@Composable
fun AppNavigation(navController: NavHostController, favoritosDao: FavoritosDao) {
    NavHost(navController = navController, startDestination = Screens.Principal.route) {
        composable(Screens.Principal.route) { ScreenPrincipal(navController) }
        composable(Screens.ListaCompleta.route) { ListaCompletaScreen(navController, favoritosDao) }
        composable(Screens.Favoritos.route) { FavoritosScreen(favoritosDao) }
        composable(
            Screens.Detalles.route + "/{nombre}",
            arguments = listOf(navArgument("nombre") { type = NavType.StringType })
        ) { backStackEntry ->
            val personajeNombre = backStackEntry.arguments?.getString("nombre") ?: ""
            DetallesScreen(personajeNombre) // Envia el nombre a DetallesScreen como argumento
        }
    }
}