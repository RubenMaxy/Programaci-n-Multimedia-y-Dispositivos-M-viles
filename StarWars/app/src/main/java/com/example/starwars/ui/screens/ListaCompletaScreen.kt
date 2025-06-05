package com.example.starwars.ui.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.network.api.RetrofitClient

@Composable
fun ListaCompletaScreen() {
    val personajes = remember { mutableStateOf<List<Personaje>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            personajes.value = RetrofitClient.api.getPersonajes() // Llamada a la API
        } catch (e: Exception) {
            Log.e("API", "Error al obtener personajes: ${e.message}")
        }
    }

    LazyColumn {
        items(personajes.value) { personaje ->
            PersonajeItem(personaje)
        }
    }
}
