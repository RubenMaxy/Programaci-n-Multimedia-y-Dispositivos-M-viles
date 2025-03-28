package com.example.trivila2.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trivila2.ui.state.TrivialViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EndGame(
    trivialViewModel: TrivialViewModel = viewModel()
) {
    val trivialState by trivialViewModel.uiState.collectAsState()
    Scaffold ( topBar={
        TopAppBar (title = { Text("Trivial VideoMax") },
            colors= TopAppBarDefaults.topAppBarColors(
                titleContentColor = Color.Magenta
            ),
            modifier = Modifier.fillMaxWidth())
    }
    ) {
        Column (modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Has terminado el juego")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = "Su puntuacion es: ${trivialState.correctPercent}")
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                onClick = {
                    trivialViewModel.navigateToHome()
                },
                modifier = Modifier
            ) {
                Text(text = "Volver al inicio")
            }
        }
    }
}