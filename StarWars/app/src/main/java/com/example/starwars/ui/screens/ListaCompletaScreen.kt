package com.example.starwars.ui.screens


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.starwars.ui.navigation.Screens
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import com.example.starwars.ui.viewModel.PersonajeViewModel

@Composable
fun ListaCompletaScreen(navController: NavController, viewModel: PersonajeViewModel) {
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.cargando) {
        Text("Cargando personajes...")
        viewModel.cargarPersonajes()
    } else {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(uiState.value.personajes) { personaje ->
                PersonajeItem(
                    personaje = personaje,
                    viewModel = viewModel
                ) {
                    viewModel.seleccionarPersonaje(personaje)
                    navController.navigate(Screens.Detalles.route)
                }
            }
        }
    }
}