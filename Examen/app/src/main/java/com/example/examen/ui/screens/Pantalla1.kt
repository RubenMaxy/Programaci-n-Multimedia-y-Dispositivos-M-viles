package com.example.examen.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Pantalla1(onNavigateToPantalla2: (String) -> Unit) {
    var userInput by remember { mutableStateOf("") }

    Column {
        // Campo de texto para que el usuario introduzca un valor
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Introduce un valor") }
        )
        // Botón para navegar a Pantalla2 con el valor proporcionado por el usuario
        Button(
            onClick = { onNavigateToPantalla2(userInput) },
            enabled = userInput.isNotEmpty() // Asegurar que el campo no esté vacío
        ) {
            Text("Ir a Pantalla 2 con el valor: $userInput")
        }
    }
}