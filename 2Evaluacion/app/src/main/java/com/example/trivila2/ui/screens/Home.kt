package com.example.trivila2.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun Home(
    trivialViewModel: TrivialViewModel = viewModel(),
) {
    val trivialState by trivialViewModel.uiState.collectAsState()
    Scaffold ( topBar={
        TopAppBar (title = { Text("Trivial VideoMax") },
        colors= TopAppBarDefaults.topAppBarColors(
            titleContentColor = Color.Green
        ))
    },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(top = 100.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        trivialViewModel.setNumberQuestions(trivialState.numberQuestions-1)
                    },
                    enabled = (if (trivialViewModel.getNumberQuestions() > 5) true else false),
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Restar 1"
                    )
                }
                Text(text = trivialState.numberQuestions.toString())
                IconButton(
                    onClick = {
                        trivialViewModel.setNumberQuestions(trivialState.numberQuestions+1)
                    },
                    enabled = (if (trivialViewModel.getNumberQuestions() < 20) true else false),
                    modifier = Modifier
                ) {
                    Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "Sumar 1")
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Button(
                    onClick = {
                        trivialViewModel.getQuestions()
                    },
                    modifier = Modifier
                ) {
                    Text(text = "Comenzar")
                }
            }
        }
    }
}