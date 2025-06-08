package com.example.starwars.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.starwars.ui.navigation.Screens
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.room.entidades.Favorito
import com.example.starwars.ui.room.entidades.toPersonaje


@Composable
fun FavoritosScreen(navController: NavController, favoritosDao: FavoritosDao) {
    val favoritos = remember { mutableStateOf<List<Favorito>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            favoritos.value = favoritosDao.obtenerFavoritos() // ✅ Recuperamos los favoritos desde Room
        } catch (e: Exception) {
            Log.e("Favoritos", "Error al obtener favoritos: ${e.message}")
        }
    }

    if (favoritos.value.isEmpty()) {
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
            items(favoritos.value.size) { index -> // Pasamos el número de elementos
                val favorito = favoritos.value[index].toPersonaje() // Convertimos Favorito en Personaje
                PersonajeItem(
                    personaje = favorito
                ) {
                    navController.currentBackStackEntry?.savedStateHandle?.set("personaje", favorito) // Guardamos el objeto
                    navController.navigate(Screens.Detalles.route) // Navegamos pasando el personaje completo
                }
            }
        }
    }
}