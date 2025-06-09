package com.example.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.starwars.ui.screens.FavoritosScreen
import com.example.starwars.ui.screens.ListaCompletaScreen
import com.example.starwars.ui.screens.ScreenPrincipal
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.screens.DetallesScreen
import com.example.starwars.ui.viewModel.PersonajeViewModel
import com.example.starwars.ui.viewModel.PersonajeViewModelFactory


@Composable
fun AppNavigation(navController: NavHostController, favoritosDao: FavoritosDao) {
    val viewModelFactory = remember { PersonajeViewModelFactory(favoritosDao) }
    val viewModel: PersonajeViewModel = viewModel(factory = viewModelFactory) // Crea el ViewModel aquí

    NavHost(navController = navController, startDestination = Screens.Principal.route) {
        composable(Screens.Principal.route) { ScreenPrincipal(navController) }
        composable(Screens.ListaCompleta.route) { ListaCompletaScreen(navController, viewModel) } // Pasamos el ViewModel
        composable(Screens.Favoritos.route) { FavoritosScreen(navController, viewModel) } // Pasamos el ViewModel
        composable(Screens.Detalles.route) {DetallesScreen(navController, viewModel) // Ahora pasamos ambos parámetros
        }
    }
}