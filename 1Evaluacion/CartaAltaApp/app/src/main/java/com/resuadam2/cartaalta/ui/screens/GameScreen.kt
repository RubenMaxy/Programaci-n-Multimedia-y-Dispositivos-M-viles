package com.resuadam2.cartaalta.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.resuadam2.cartaalta.ui.state.GameScreenViewModel

@Composable
fun GameScreen (
    onBackToMenu: () -> Unit,
    onGameOver: (String) -> Unit,
) {
    GameScreenContent(
        onBackToMenu = onBackToMenu,
        onGameOver = onGameOver,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreenContent(
    onBackToMenu: () -> Unit,
    onGameOver: (String) -> Unit,
    gameScreenVM: GameScreenViewModel = viewModel()
) {
    val state by gameScreenVM.state.collectAsState()
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Carta Alta") },
                navigationIcon = {
                    IconButton(
                        onClick = onBackToMenu
                    ) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back to home")
                    }
                },
                colors = TopAppBarColors(
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                )
                )
        }

    ) {
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            PlayerCard(
                playerName = "Jugador 1",
                haTirado = state.jugador1HaTirado,
                carta = state.jugador1Carta.toString(),
                onTirar = { gameScreenVM.jugador1Tira() },
            )
            PlayerCard(
                playerName = "Jugador 2",
                haTirado = state.jugador2HaTirado,
                carta = state.jugador2Carta.toString(),
                onTirar = { gameScreenVM.jugador2Tira() }
            )
            Button(
                onClick = {
                    onGameOver(state.ganador)
                          },
                enabled = gameScreenVM.todosHanTirado(),
                content = { Text("Terminar partida") }
            )
        }
    }


}

@Composable
fun PlayerCard(
    playerName: String,
    haTirado: Boolean = false,
    carta: String = "",
    onTirar: () -> Unit
    ) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onTirar,
            enabled = !haTirado,
            content = { Text("Area de juego de $playerName") }
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = if (haTirado) "Su carta es: $carta" else "No ha robado aún",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
