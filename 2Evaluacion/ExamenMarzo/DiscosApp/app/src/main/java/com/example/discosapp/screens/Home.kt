package com.example.discosapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.discosapp.data.Disco
import com.example.discosapp.state.DiscosModel


@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Home(
    navigateToAddDiscos: () -> Unit,
    navigateToDiscosDetails: () -> Unit,
    modifier: Modifier = Modifier,
    discosModel: DiscosModel = viewModel()
    ) {
        val state by discosModel.uiState.collectAsState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Discos App Rubén Alonso") },
                    colors = TopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        scrolledContainerColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            floatingActionButton = {
                // FloatingActionButton para añadir un Disco
                FloatingActionButton(
                    onClick = navigateToAddDiscos,
                    containerColor = MaterialTheme.colorScheme.secondary
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        tint = MaterialTheme.colorScheme.onSecondary,
                        contentDescription = "Añadir disco"
                    )
                }
            }
        ) {
            Column(
                modifier = modifier.padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                state.discos.forEach { disco ->
                    DiscoItem(
                        disco = disco,
                        onView = navigateToDiscosDetails,
                        onDelete = {
                            discosModel.deleteDisco(disco)
                        }
                    )
                }
            }
        }
    }

    @Composable
    fun DiscoItem(disco: Disco, onView: () -> Unit, onDelete: () -> Unit) {
        // Implementación de la vista de un Disco
        Card (
            modifier = Modifier.background(Color.Transparent).padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Row (
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = disco.titulo,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = onView
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Ver disco"
                    )
                }

                IconButton(
                    onClick = onDelete
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar Disco"
                    )
                }
            }
        }
    }