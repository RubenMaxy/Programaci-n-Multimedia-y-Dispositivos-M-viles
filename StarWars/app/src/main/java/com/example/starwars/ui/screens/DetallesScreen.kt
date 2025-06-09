package com.example.starwars.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.starwars.ui.viewModel.PersonajeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetallesScreen(
    navController: NavController,
    viewModel: PersonajeViewModel
) {
    val uiState = viewModel.uiState.collectAsState() // Estado de la UI

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (uiState.value.cargando) {
            Text(text = "Cargando personaje...", fontSize = 18.sp, color = Color.Gray)
        } else {
            uiState.value.personajeSeleccionado?.let { personaje ->
                Text(text = personaje.nombre, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "Altura: ${personaje.altura}", fontSize = 18.sp)
                Text(text = "Color de pelo: ${personaje.colorPelo}", fontSize = 18.sp)
                Text(text = "Nacimiento: ${personaje.nacimiento}", fontSize = 18.sp)
            } ?: Text(text = "Personaje no encontrado", fontSize = 18.sp, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Películas:", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        if (uiState.value.peliculas.isEmpty() && !uiState.value.cargando) {
            Text(text = "No hay películas disponibles", fontSize = 18.sp, color = Color.Gray)
        }

        LazyColumn {
            items(uiState.value.peliculas) { pelicula ->
                Column(modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(text = pelicula.titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "🎬 Director: ${pelicula.director}", fontSize = 16.sp)
                    Text(text = "📅 Estreno: ${pelicula.estreno}", fontSize = 16.sp)
                    Text(text = "📖 Descripción:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = pelicula.descripcion, fontSize = 16.sp, color = Color.Gray)
                }
            }
        }

        uiState.value.error?.let { error ->
            Text(text = error, fontSize = 16.sp, color = Color.Red) // Manejo de errores en la UI
        }
    }
}