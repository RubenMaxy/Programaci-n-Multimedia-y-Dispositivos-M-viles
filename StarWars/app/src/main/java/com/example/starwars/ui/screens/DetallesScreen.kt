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
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.viewModel.PersonajeViewModel
import com.example.starwars.ui.viewModel.PersonajeViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetallesScreen(navController: NavController, favoritosDao: FavoritosDao) {
    val viewModelFactory = remember { PersonajeViewModelFactory(favoritosDao) }
    val viewModel: PersonajeViewModel = viewModel(factory = viewModelFactory)
    val peliculasState = viewModel.peliculas.collectAsState() // Agrega este estado

    val personajeState = viewModel.personajeSeleccionado.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        personajeState?.let {
            Text(text = it.value?.nombre ?: "", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Altura: ${it.value?.altura}", fontSize = 18.sp)
            Text(text = "Color de pelo: ${it.value?.colorPelo}", fontSize = 18.sp)
            Text(text = "Nacimiento: ${it.value?.nacimiento}", fontSize = 18.sp)
        } ?: Text(text = "Cargando personaje...", fontSize = 18.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Películas:", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        LazyColumn {
            items(peliculasState.value) { pelicula ->
                Column(modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(text = pelicula.titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "🎬 Director: ${pelicula.director}", fontSize = 16.sp)
                    Text(text = "📅 Estreno: ${pelicula.estreno}", fontSize = 16.sp)
                    Text(text = "📖 Descripción:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = pelicula.descripcion, fontSize = 16.sp, color = Color.Gray)
                }
            }
        }
    }
}