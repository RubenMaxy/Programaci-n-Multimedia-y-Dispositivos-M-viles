package com.example.starwars.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.room.entidades.Favorito


@Composable
fun FavoritosScreen(favoritosDao: FavoritosDao) {
    val favoritos = remember { mutableStateOf<List<Favorito>>(emptyList()) }

    LaunchedEffect(Unit) {
        favoritos.value = favoritosDao.obtenerFavoritos()
    }

    LazyColumn {
        items(favoritos.value) { favorito ->
            Text(text = favorito.nombre, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}
