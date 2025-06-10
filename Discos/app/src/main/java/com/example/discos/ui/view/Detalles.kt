package com.example.discos.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.discos.ui.data.Discos
import com.example.discos.ui.viewModel.DiscoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detalles(navController: NavController, viewModel: DiscoViewModel) {
    val disco = navController.previousBackStackEntry?.savedStateHandle?.get<Discos>("disco")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles del Disco") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            disco?.let {
                Text(text = "Título: ${it.titulo}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "Autor: ${it.autor}", fontSize = 18.sp)
                Text(text = "Número de canciones: ${it.numCanciones}", fontSize = 18.sp)
                Text(text = "Año de publicación: ${it.publicacion}", fontSize = 18.sp)
                Text(text = "Valoración: ${it.valoracion} ⭐", fontSize = 18.sp)
            } ?: Text(text = "Error: Disco no encontrado", fontSize = 18.sp, color = Color.Red)
        }
    }
}