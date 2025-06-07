package com.example.starwars.ui.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.navigation.Screens
import com.example.starwars.ui.network.api.RetrofitClient
import com.example.starwars.ui.room.dao.FavoritosDao

@Composable
fun ListaCompletaScreen(navController: NavController, favoritosDao: FavoritosDao) {
    val personajes = remember { mutableStateOf<List<Personaje>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            val response = RetrofitClient.apiPersonajes.getPersonajes()
            Log.d("API", "Datos recibidos: $response") // ✅ Verifica qué datos llegan
            personajes.value = response
        } catch (e: Exception) {
            Log.e("API", "Error al obtener personajes: ${e.message}")
        }
    }

    LazyColumn {
        if (personajes.value.isEmpty()) {
            item { Text(text = "No hay personajes disponibles", fontSize = 18.sp) } // ✅ Manejar lista vacía
        } else {
            items(personajes.value) { personaje ->
                PersonajeItem(personaje, favoritosDao) {
                    navController.navigate("${Screens.Detalles.route}/${personaje.nombre}")
                }
            }
        }
    }
}
