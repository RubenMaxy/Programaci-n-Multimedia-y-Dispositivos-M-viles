package com.example.starwars.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import com.example.starwars.ui.screens.FavoritosScreen
import com.example.starwars.ui.screens.ListaCompletaScreen
import com.example.starwars.ui.screens.ScreenPrincipal
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.starwars.ui.data.modelo.Personaje
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.screens.DetallesScreen
import com.example.starwars.ui.viewModel.PersonajeViewModel
import com.example.starwars.ui.viewModel.PersonajeViewModelFactory


@Composable
fun AppNavigation(navController: NavHostController, favoritosDao: FavoritosDao) {
    val viewModelFactory = PersonajeViewModelFactory(favoritosDao)
    val viewModel: PersonajeViewModel = ViewModelProvider(
        LocalViewModelStoreOwner.current!!,
        viewModelFactory
    ).get(PersonajeViewModel::class.java)

    NavHost(navController = navController, startDestination = Screens.Principal.route) {
        composable(Screens.Principal.route) { ScreenPrincipal(navController) }
        composable(Screens.ListaCompleta.route) { ListaCompletaScreen(navController, viewModel) }
        composable(Screens.Favoritos.route) { FavoritosScreen(navController, viewModel) }
        composable(Screens.Detalles.route) { backStackEntry ->
            val personaje = navController.previousBackStackEntry?.savedStateHandle?.get<Personaje>("personaje")
            personaje?.let {
                DetallesScreen(navController, viewModel)
            } ?: Log.e("DetallesScreen", "Error: Personaje no encontrado")
        }
    }
}