package com.example.starwars.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.starwars.ui.screens.FavoritosScreen
import com.example.starwars.ui.screens.ListaCompletaScreen
import com.example.starwars.ui.screens.ScreenPrincipal
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.screens.DetallesScreen


@Composable
fun AppNavigation(navController: NavHostController, favoritosDao: FavoritosDao) {
    NavHost(navController = navController, startDestination = Screens.Principal.route) {
        composable(Screens.Principal.route) { ScreenPrincipal(navController) }
        composable(Screens.ListaCompleta.route) { ListaCompletaScreen(navController, favoritosDao) }
        composable(Screens.Favoritos.route) { FavoritosScreen(navController,favoritosDao) }
        composable(Screens.Detalles.route) { backStackEntry ->
            val personaje = navController.previousBackStackEntry?.savedStateHandle?.get<Personaje>("personaje")
            personaje?.let {
                DetallesScreen(it) // Si el personaje existe, lo pasamos a la pantalla de detalles
            } ?: Log.e("DetallesScreen", "Error: Personaje no encontrado") // Agrega un Log para verificar si el objeto llega
        }

    }
}