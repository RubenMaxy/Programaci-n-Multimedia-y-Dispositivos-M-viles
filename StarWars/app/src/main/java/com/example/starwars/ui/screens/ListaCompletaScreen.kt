package com.example.starwars.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.navigation.Screens
import com.example.starwars.ui.network.api.RetrofitClient
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.room.entidades.Favorito
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ListaCompletaScreen(navController: NavController, favoritosDao: FavoritosDao) {
    val personajes = remember { mutableStateOf<List<Personaje>>(emptyList()) }
    val favoritos = remember { mutableStateOf<List<Favorito>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            personajes.value = RetrofitClient.apiPersonajes.getPersonajes()
            favoritos.value = favoritosDao.obtenerFavoritos()
        } catch (e: Exception) {
            Log.e("API", "Error al obtener datos: ${e.message}")
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), //Muestra 2 columnas
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        items(personajes.value) { personaje ->
            val esFavorito = favoritos.value.any { it.nombre == personaje.nombre }
            PersonajeItem(personaje, favoritosDao, esFavorito) {
                navController.currentBackStackEntry?.savedStateHandle?.set("personaje", personaje) // Guardamos el objeto
                navController.navigate(Screens.Detalles.route) // Navegamos pasando el personaje completo
            }
        }
    }
}