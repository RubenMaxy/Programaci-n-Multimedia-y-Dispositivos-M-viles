package com.example.listcompra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
                Lista(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 30.dp),
                )
            }
        }
    }
}

    @Composable
    fun Lista(modifier: Modifier = Modifier) {
        var valor by remember { mutableStateOf("") }
        var listaCompra by remember { mutableStateOf(mutableListOf("Tomates", "Ajos")) }
        Row(modifier = modifier) {
            TextField(
                value = valor,
                onValueChange = { valor = it })
            IconButton(onClick = {
                listaCompra.add(valor)
                valor=""}) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Añadir a la lista")
            }
        }
        Elementos(listaCompra, modifier = Modifier)
    }


@Composable
fun Elementos (listaCompra:MutableList<String>,
               modifier: Modifier =Modifier){
    var lista by remember { mutableStateOf(mutableListOf(listaCompra)) }
    LazyColumn(modifier = modifier
        .padding(vertical = 100.dp)) {
        items(listaCompra) { index ->
            Row {
                Text(index, modifier = modifier.padding(vertical = 15.dp))
                var marcada by remember { mutableStateOf(false) }
                Checkbox(checked = marcada, onCheckedChange= {marcada=!marcada},
                    modifier = modifier)
                IconButton(onClick = {
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                }
            }
        }
    }
}
