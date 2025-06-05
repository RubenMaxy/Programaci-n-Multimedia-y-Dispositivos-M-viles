package com.example.starwars.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.starwars.ui.modelo.Personaje

@Composable
fun PersonajeItem(personaje: Personaje) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Verifica que haya al menos una imagen antes de intentar mostrarla
        AsyncImage(
            model = personaje.imagenes.firstOrNull() ?: "", // Usa la primera imagen o una cadena vacía si no hay imágenes
            contentDescription = "Imagen de ${personaje.nombre}",
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(text = personaje.nombre, fontSize = 18.sp)
    }
}

