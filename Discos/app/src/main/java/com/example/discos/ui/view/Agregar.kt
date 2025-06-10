package com.example.discos.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.discos.ui.data.Discos
import com.example.discos.ui.viewModel.DiscoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Agregar(navController: NavController, viewModel: DiscoViewModel) {
    val uiState = viewModel.uiState.collectAsState()

    val datosValidos = uiState.value.titulo.isNotBlank() &&
            uiState.value.autor.isNotBlank() &&
            uiState.value.numCanciones.toIntOrNull() in 1..99 &&
            uiState.value.publicacion.toIntOrNull() in 1000..2030 &&
            uiState.value.valoracion.toIntOrNull() in 1..5

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agregar Disco") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize(), verticalArrangement = Arrangement.Center) {
            TextField(
                value = uiState.value.titulo,
                onValueChange = { viewModel.actualizarTitulo(it) },
                label = { Text("Título") }
            )
            TextField(
                value = uiState.value.autor,
                onValueChange = { viewModel.actualizarAutor(it) },
                label = { Text("Autor") }
            )
            TextField(
                value = uiState.value.numCanciones,
                onValueChange = { viewModel.actualizarNumCanciones(it) },
                label = { Text("Número de Canciones") }
            )
            TextField(
                value = uiState.value.publicacion,
                onValueChange = { viewModel.actualizarPublicacion(it) },
                label = { Text("Año de Publicación") }
            )
            TextField(
                value = uiState.value.valoracion,
                onValueChange = { viewModel.actualizarValoracion(it) },
                label = { Text("Valoración (1-5)") }
            )

            Button(
                onClick = {
                    viewModel.agregarDisco()
                    navController.popBackStack()
                },
                enabled = datosValidos
            ) {
                Text("Añadir Disco")
            }
        }
    }
}