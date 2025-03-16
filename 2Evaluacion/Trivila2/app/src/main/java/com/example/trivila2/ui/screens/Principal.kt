package com.example.trivila2.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.trivila2.ui.state.TrivialViewModel
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun Principal(trivialViewModel: TrivialViewModel = viewModel()){
    val trivialState by trivialViewModel.uiState.collectAsState()
    when (trivialState.screen.toString()) {
        "HOME" -> Home()
        "GAME" -> Game()
        "ENDGAME" -> EndGame()
        "LOADING" -> Loading()
    }
}