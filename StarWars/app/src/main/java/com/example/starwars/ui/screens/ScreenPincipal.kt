package com.example.starwars.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.system.exitProcess

@Composable
fun ScreenPrincipal(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón para ver lista completa
        Button(onClick = { navController.navigate("listaCompleta") }) {
            Text(text = "Ver Lista Completa")
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espaciado entre botones

        // Botón para ver favoritos
        Button(onClick = { navController.navigate("favoritos") }) {
            Text(text = "Ver Favoritos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para salir de la app
        Button(onClick = { exitProcess(0) }) {
            Text(text = "Salir")
        }
    }
}