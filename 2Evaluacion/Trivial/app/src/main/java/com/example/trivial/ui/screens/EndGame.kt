package com.example.trivial.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trivial.ui.state.TrivialViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EndGame(
    navigateToHome:()->Unit,
    trivialViewModel: TrivialViewModel = viewModel()
) {
    val trivialState by trivialViewModel.uiState.collectAsState()
    Scaffold ( topBar={
        TopAppBar (title = { Text("Trivial VideoMax") },
        colors= TopAppBarDefaults.topAppBarColors(
            titleContentColor = Color.Green
        ))
    },
        modifier = Modifier
    ) {
        Column (modifier = Modifier.fillMaxWidth()){
            Text(text = "Has terminado el juego")
            Text(text = "Su puntuacion es: ${trivialState.correctPercent}%")
        }
    }
}