package com.resuadam2.cartaalta.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameOverScreen(
    ganador: String,
    onRestart: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            if (
                ganador == "Empate"
            ) "Ha habido un empate" else "Ha ganado el jugador $ganador",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.size(64.dp))
        Button(
            onClick = {
                onRestart()
            },
            content = {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Reiniciar"
                )
                Text("Reiniciar")
            }
        )
    }
}