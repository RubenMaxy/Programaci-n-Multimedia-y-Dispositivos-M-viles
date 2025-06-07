package com.example.starwars.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.room.entidades.Favorito
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PersonajeItem(personaje: Personaje, favoritosDao: FavoritosDao, onClick: () -> Unit) {
    var esFavorito by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Column {
            Text(text = personaje.nombre, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "Altura: ${personaje.altura}", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Color de pelo: ${personaje.colorPelo}", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Nacimiento: ${personaje.nacimiento}", fontSize = 14.sp, color = Color.Gray)

            IconButton(onClick = {
                esFavorito = !esFavorito
                CoroutineScope(Dispatchers.IO).launch {
                    if (esFavorito) {
                        favoritosDao.agregarFavorito(Favorito(personaje.nombre, personaje.altura, personaje.colorPelo, personaje.nacimiento))
                    } else {
                        favoritosDao.eliminarFavorito(Favorito(personaje.nombre, personaje.altura, personaje.colorPelo, personaje.nacimiento))
                    }
                }
            }) {
                Icon(imageVector = if (esFavorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder, contentDescription = "Favorito")
            }
        }
    }
}