package com.example.starwars.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwars.ui.modelo.Personaje

@Composable
fun PersonajeItem(personaje: Personaje, onClick: () -> Unit) {
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
        }
    }
}



