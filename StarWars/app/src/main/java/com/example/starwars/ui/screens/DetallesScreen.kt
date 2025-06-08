package com.example.starwars.ui.screens


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.starwars.ui.modelo.Personaje
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.starwars.ui.modelo.Pelicula
import com.example.starwars.ui.network.api.RetrofitClient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetallesScreen(personaje: Personaje) {
    val peliculas = remember { mutableStateOf<List<Pelicula>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            personaje.peliculas.forEach { peliculaUrl ->
                val peliculaId = peliculaUrl.split("/").last()
                val peliculaInfo = RetrofitClient.apiPeliculas.getPelicula(peliculaId)
                peliculas.value += peliculaInfo
            }
        } catch (e: Exception) {
            Log.e("API", "Error al obtener detalles: ${e.message}")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize() // Asegura que la pantalla ocupa todo el espacio disponible
            .padding(16.dp)
    ) {
        // Sección de información del personaje
        Card(
            modifier = Modifier.fillMaxWidth(), // Hace que el contenido se expanda en toda la pantalla
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = personaje.nombre, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "Altura: ${personaje.altura}", fontSize = 18.sp)
                Text(text = "Color de pelo: ${personaje.colorPelo}", fontSize = 18.sp)
                Text(text = "Nacimiento: ${personaje.nacimiento}", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sección de películas del personaje
        Text(text = "Películas:", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        LazyColumn(
            modifier = Modifier.fillMaxWidth() // Asegura que la lista de películas también ocupe todo el ancho
        ) {
            items(peliculas.value) { pelicula ->
                Card(
                    modifier = Modifier.fillMaxWidth(), // Expande cada película al ancho completo
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
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
}


