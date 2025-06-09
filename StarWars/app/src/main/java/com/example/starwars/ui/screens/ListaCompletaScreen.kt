package com.example.starwars.ui.screens


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.starwars.ui.navigation.Screens
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.starwars.ui.viewModel.PersonajeViewModel

@Composable
fun ListaCompletaScreen(navController: NavController, viewModel: PersonajeViewModel) { // Recibimos el ViewModel desde la navegación
    val uiState = viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.cargarPersonajes() // Los personajes se cargan al iniciar la pantalla
    }
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(uiState.value.personajes) { personaje ->
            PersonajeItem(personaje = personaje, viewModel = viewModel) {
                viewModel.seleccionarPersonaje(personaje) // Guarda el personaje en el ViewModel
                navController.currentBackStackEntry?.savedStateHandle?.set("personaje", personaje) // ✅ Guardamos el personaje antes de navegar
                navController.navigate(Screens.Detalles.route)
            }
        }
    }
}
