package com.example.starwars.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwars.ui.modelo.Pelicula
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.network.api.RetrofitClient

@Composable
fun DetallesScreen(personajeNombre: String) {
    val personajes = remember { mutableStateOf<List<Personaje>>(emptyList()) }
    val peliculas = remember { mutableStateOf<List<Pelicula>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            personajes.value = RetrofitClient.apiPersonajes.getPersonajes()
            val personaje = personajes.value.find { it.nombre == personajeNombre }

            // Si encontramos al personaje, llamamos a la API de cada película
            personaje?.peliculas?.forEach { peliculaUrl ->
                val peliculaId = peliculaUrl.split("/").last() // Extrae el ID de la URL
                val peliculaInfo = RetrofitClient.apiPeliculas.getPelicula(peliculaId)
                peliculas.value += peliculaInfo // Agrega la película a la lista
            }
        } catch (e: Exception) {
            Log.e("API", "Error al obtener detalles: ${e.message}")
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = personajeNombre, fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Películas", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        LazyColumn {
            items(peliculas.value) { pelicula ->
                Text(text = pelicula.titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "Dirigida por: ${pelicula.director}", fontSize = 14.sp)
                Text(text = "Estreno: ${pelicula.estreno}", fontSize = 14.sp)
                Text(text = pelicula.descripcion, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

