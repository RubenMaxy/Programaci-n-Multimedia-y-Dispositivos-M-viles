package com.example.discos.ui.navigation


import com.example.discos.ui.data.Discos
import com.example.discos.ui.room.dao.DiscosDao
import com.example.discos.ui.view.Home
import com.example.discos.ui.viewModel.DiscoViewModel
import com.example.discos.ui.viewModel.DiscoViewModelFactory
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import android.util.Log
import com.example.discos.ui.view.Agregar
import com.example.discos.ui.view.Detalles


@Composable
fun AppNavigation(navController: NavHostController, discoDao: DiscosDao) {
    val viewModelFactory = DiscoViewModelFactory(discoDao)
    val viewModel: DiscoViewModel = ViewModelProvider(
        LocalViewModelStoreOwner.current!!,
        viewModelFactory
    ).get(DiscoViewModel::class.java)

    NavHost(navController = navController, startDestination = Screens.HOME.name) {
        composable(Screens.HOME.name) { Home(navController, viewModel) }
        composable(Screens.DETALLES.name) { backStackEntry ->
            val disco = navController.previousBackStackEntry?.savedStateHandle?.get<Discos>("disco")
            disco?.let {
                Detalles(navController, viewModel)
            } ?: Log.e("DetallesScreen", "Error: Disco no encontrado")
        }
        composable(Screens.AGREGAR.name) { Agregar(navController, viewModel) }
    }
}