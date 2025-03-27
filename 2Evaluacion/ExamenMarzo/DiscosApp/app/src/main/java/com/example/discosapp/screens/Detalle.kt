package com.example.discosapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Detalle(
    disco: String,
    navigateBack: ()-> Unit,
    modifier: Modifier = Modifier
){
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text("Detalles del disco")
                    },
                    navigationIcon = {
                        IconButton(onClick = navigateBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                        }
                    }
                )
            }
        ) {
            Column (
                modifier = modifier.padding(it).fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                DetailsDiscoForm(
                    disco= disco,
                    onCancel = navigateBack
                )
            }
        }
    }


    @Composable
    fun DetailsDiscoForm(
        disco: String,
        onCancel: () -> Unit = {}
    ) {
        Text(disco)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onCancel,
            ) {
                Text("Cancelar")
            }
        }
}