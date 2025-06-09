package com.example.starwars.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.starwars.ui.navigation.Screens
import com.example.starwars.ui.room.entidades.toPersonaje
import com.example.starwars.ui.viewModel.PersonajeViewModel


@Composable
fun FavoritosScreen(navController: NavController, viewModel: PersonajeViewModel) {
    val favoritosState = viewModel.uiState.collectAsState() // Estado

    if (favoritosState.value.favoritos.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No hay personajes favoritos aún.",
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            items(favoritosState.value.favoritos.size) { favorito ->
                val personaje = favoritosState.value.favoritos.get(favorito).toPersonaje() // Convertimos `Favorito` a `Personaje`
                PersonajeItem(
                    personaje = personaje,
                    viewModel = viewModel // Pasamos el ViewModel de la pantalla
                ) {
                    viewModel.seleccionarPersonaje(personaje) // Guardamos en `ViewModel`
                    navController.navigate(Screens.Detalles.route) // Navegamos a detalles
                }
            }
        }
    }
}