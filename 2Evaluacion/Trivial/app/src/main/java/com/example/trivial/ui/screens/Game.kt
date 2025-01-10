package com.example.trivial.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trivial.ui.state.TrivialViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Game(
    navigateToEndGame: () ->Unit,
    trivialViewModel: TrivialViewModel = viewModel()

) {
    val trivialState by trivialViewModel.uiState.collectAsState()
    Scaffold (){
        Column (){
            Text(text= trivialState.listQuestions[trivialState.actualQuestion].question,
                modifier = Modifier.fillMaxSize()
                    .align(Alignment.CenterHorizontally))
            Button(onClick = {trivialViewModel.answer()},
                enabled = trivialViewModel.getIsAnswer()) {}

        }
    }
}