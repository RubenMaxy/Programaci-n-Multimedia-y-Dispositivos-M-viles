package com.example.trivial.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EndGame(
    navigateToHome:()->Unit,
    points: Double,
) {

    Scaffold ( topBar={
        TopAppBar (title = { Text("Trivial VideoMax") },
        colors= TopAppBarDefaults.topAppBarColors(
            titleContentColor = Color.Green
        ))
    },
        modifier = Modifier
    ) {
        Column (modifier = Modifier
            .padding(top = 110.dp)){
            Text(text = "Has terminado el juego")
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = "Su puntuacion es: $points%")
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                onClick = {
                    navigateToHome()
                },
                modifier = Modifier
            ) {
                Text(text = "Volver al inicio")
            }
        }
    }
}