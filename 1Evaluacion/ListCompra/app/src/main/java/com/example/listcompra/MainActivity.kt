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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
                val valor = remember { (mutableStateOf("")) }
                val listaCompra = remember { (mutableStateListOf("")) }
                Lista(listaCompra,
                    valor,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 30.dp),
                )
                Elementos(listaCompra, modifier = Modifier)
            }
        }
    }
}

@Composable
fun Lista(listaCompra:MutableList<String> ,
          valor:MutableState<String>,
          modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        TextField(
            value = valor.value,
            onValueChange = { valor.value = it })
        IconButton(onClick = {
            listaCompra.add(valor.value)
            valor.value=""}) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Añadir a la lista")
        }
    }
}

@Composable
fun Elementos (listaCompra:MutableList<String>,
               modifier: Modifier =Modifier){
    LazyColumn(modifier = modifier
        .padding(vertical = 100.dp)) {
        items(listaCompra) { index ->
            Row {
                Text(index, modifier = modifier.padding(vertical = 15.dp))
                var marcada by remember { mutableStateOf(false) }
                Checkbox(checked = marcada, onCheckedChange= {marcada=!marcada},
                    modifier = modifier)
                IconButton(onClick = {
                    listaCompra.remove(index)
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                }
            }
        }
    }
}
