package com.example.discos.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.discos.ui.data.Discos
import com.example.discos.ui.room.dao.DiscosDao
import com.example.discos.ui.viewModel.DiscoViewModel
import com.example.discos.ui.viewModel.DiscoViewModelFactory

@Composable
fun AppNavigation(navController: NavHostController, discoDao: DiscosDao) {
    val viewModelFactory = DiscoViewModelFactory(discoDao)
    val viewModel: DiscoViewModel = ViewModelProvider(
        LocalViewModelStoreOwner.current!!,
        viewModelFactory
    ).get(DiscoViewModel::class.java) // Usamos `ViewModelProvider`

    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) { HomeScreen(navController, viewModel) }
        composable(Screens.Detalles.route) { backStackEntry ->
            val disco = navController.previousBackStackEntry?.savedStateHandle?.get<Discos>("disco")
            disco?.let {
                DetallesScreen(navController, viewModel)
            } ?: Log.e("DetallesScreen", "Error: Disco no encontrado")
        }
        composable(Screens.Agregar.route) { AgregarDiscoScreen(navController, viewModel) }
    }
}
