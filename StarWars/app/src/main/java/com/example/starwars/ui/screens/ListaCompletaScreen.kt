package com.example.starwars.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.starwars.ui.navigation.Screens
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.viewModel.PersonajeViewModel
import com.example.starwars.ui.viewModel.PersonajeViewModelFactory

@Composable
fun ListaCompletaScreen(navController: NavController, favoritosDao: FavoritosDao) {
    val viewModelFactory = remember { PersonajeViewModelFactory(favoritosDao) }
    val viewModel: PersonajeViewModel = viewModel(factory = viewModelFactory)

    LaunchedEffect(Unit) { viewModel.cargarPersonajes() }

    val personajesState = viewModel.personajes.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
        items(personajesState.value) { personaje ->
            PersonajeItem(
                personaje = personaje,
                viewModel = viewModel // Pasamos el ViewModel para manejar favoritos
            ) {
                viewModel.seleccionarPersonaje(personaje) // Guarda el personaje en el ViewModel
                navController.navigate(Screens.Detalles.route) // Navega sin pasar datos extra
            }
        }
    }
}