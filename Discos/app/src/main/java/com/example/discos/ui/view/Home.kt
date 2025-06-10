package com.example.discos.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.discos.ui.navigation.Screens
import com.example.discos.ui.viewModel.DiscoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController, viewModel: DiscoViewModel) {
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("DiscosApp - Ruben") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screens.AGREGAR.name) }) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar Disco")
            }
        },
        bottomBar = {
            if (uiState.value.discos.isEmpty()) {
                Text(text = "Todavía no hay discos añadidos", fontSize = 16.sp, color = Color.Gray)
            } else {
                Text(text = "Promedio de valoraciones: ${viewModel.calcularPromedioValoracion()} ⭐", fontSize = 18.sp)
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            if (uiState.value.discos.isEmpty()) {
                Icon(Icons.Filled.Warning, contentDescription = "Lista Vacía")
                Text(text = "No hay discos añadidos todavía")
                Button(onClick = { viewModel.cargarDiscosPorDefecto() }) {
                    Text("Cargar discos por defecto")
                }
            } else {
                LazyColumn {
                    items(uiState.value.discos) { disco ->
                        Card(modifier = Modifier.fillMaxWidth().padding(8.dp).clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.set("disco", disco)
                            navController.navigate(Screens.DETALLES.name)
                        }) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = disco.titulo, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                Text(text = "Autor: ${disco.autor}", fontSize = 16.sp)
                                EstrellasValoracion(disco.valoracion) // Llama a la función con la puntuación del disco
                                IconButton(onClick = { viewModel.seleccionarDiscoParaEliminar(disco) }) {
                                    Icon(Icons.Filled.Delete, contentDescription = "Eliminar Disco")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //  Integrar la ventana de confirmación de eliminación sin alterar la lógica existente
    uiState.value.discoAEliminar?.let { disco ->
        AlertDialog(
            onDismissRequest = { viewModel.cancelarEliminacion() },
            title = { Text("Eliminar Disco") },
            text = { Text("¿Seguro que quieres eliminar '${disco.titulo}'?") },
            confirmButton = {
                Button(onClick = { viewModel.confirmarEliminacion() }) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                Button(onClick = { viewModel.cancelarEliminacion() }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
fun EstrellasValoracion(valoracion: Int) {
    val starColor = MaterialTheme.colorScheme.primary // Color del tema

    Row {
        repeat(5) { index ->
            Icon(
                imageVector = if (index < valoracion) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = "Estrella de valoración",
                tint = if (index < valoracion) starColor else Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}