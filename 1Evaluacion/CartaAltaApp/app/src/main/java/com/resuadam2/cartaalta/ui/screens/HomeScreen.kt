package com.resuadam2.cartaalta.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(
    onPlay: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido al juego de Carta Alta",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary)
        Text("Pulsa en 'Jugar' para comenzar",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary)
        Button(
            onClick = {
                onPlay()
            },
            content = {
                Text("Jugar")
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Jugar"
                )
            }
        )
    }
}