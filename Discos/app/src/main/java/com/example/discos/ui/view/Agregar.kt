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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.discos.ui.data.Discos
import com.example.discos.ui.viewModel.DiscoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarDiscoScreen(navController: NavController, viewModel: DiscoViewModel) {
    var titulo = remember { mutableStateOf("") }
    var autor = remember { mutableStateOf("") }
    var numCanciones = remember { mutableStateOf("") }
    var publicacion = remember { mutableStateOf("") }
    var valoracion = remember { mutableStateOf("") }

    val datosValidos = titulo.value.isNotBlank() &&
            autor.value.isNotBlank() &&
            numCanciones.value.toIntOrNull() in 1..99 &&
            publicacion.value.toIntOrNull() in 1000..2030 &&
            valoracion.value.toIntOrNull() in 1..5

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
            TextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") })
            TextField(value = autor, onValueChange = { autor = it }, label = { Text("Autor") })
            TextField(value = numCanciones, onValueChange = { numCanciones = it }, label = { Text("Número de Canciones") })
            TextField(value = publicacion, onValueChange = { publicacion = it }, label = { Text("Año de Publicación") })
            TextField(value = valoracion, onValueChange = { valoracion = it }, label = { Text("Valoración (1-5)") })

            Button(onClick = {
                viewModel.agregarDisco(
                    Discos(titulo = titulo, autor = autor, numCanciones = numCanciones.toInt(), publicacion = publicacion.toInt(), valoracion = valoracion.toInt())
                )
                navController.popBackStack()
            }, enabled = datosValidos) {
                Text("Añadir Disco")
            }
        }
    }
}
