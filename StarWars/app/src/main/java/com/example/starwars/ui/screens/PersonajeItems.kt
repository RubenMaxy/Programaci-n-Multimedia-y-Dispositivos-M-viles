package com.example.starwars.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.viewModel.PersonajeViewModel

@Composable
fun PersonajeItem(personaje: Personaje, viewModel: PersonajeViewModel, onItemClick: () -> Unit) {
    val favoritosState = viewModel.uiState.collectAsState()
    val esFavorito = remember { derivedStateOf<Boolean> { favoritosState.value.favoritos.any() { it.nombre == personaje.nombre } } }

    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onItemClick() } // Permite la navegación al tocar el personaje
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = personaje.nombre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Altura: ${personaje.altura}", fontSize = 16.sp)
            Text(text = "Color de pelo: ${personaje.colorPelo}", fontSize = 16.sp)
            Text(text = "Año de nacimiento: ${personaje.nacimiento}", fontSize = 16.sp)

            IconButton(onClick = { viewModel.alternarFavorito(personaje) }) {
                Icon(
                    imageVector = if (esFavorito.value) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorito"
                )
            }
        }
    }
}