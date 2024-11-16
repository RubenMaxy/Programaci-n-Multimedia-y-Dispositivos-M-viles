package com.example.listcompra



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val listaCompra by remember { mutableStateOf(mutableListOf("Tomates", "Manzanas")) }
            Column {
                anadir(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp), listaCompra
                )
                lista(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    listaCompra = listaCompra,
                    Alignment.CenterHorizontally,
                    Arrangement.SpaceBetween,
                )
            
        }
    }
}
@Composable
fun anadir(modifier: Modifier = Modifier, listaCompra: MutableList<String>) {
    var valor by remember { mutableStateOf("") }
    Row(modifier = modifier) {
        TextField(
            value=valor,
            onValueChange = {valor = it})
        IconButton(onClick = {listaCompra.add(valor)} ){
            Icon (Icons.Default.ShoppingCart, contentDescription = "Añadir a la lista")
        }
    }
}

@Composable
fun lista(
    modifier: Modifier = Modifier,
    listaCompra: MutableList<String>,
    center: Alignment.Horizontal,
    spaceBetween: Arrangement.HorizontalOrVertical
){
    LazyColumn {
       //items(listaCompra.size){ index ->     Text(text =(listaCompra.get(index)) ,modifier=modifier)    }
        items(listaCompra.size) { index ->
            ElementosLista(modifier, elemento = listaCompra.get(index))
        }
    }
}

@Composable
fun ElementosLista(modifier: Modifier=Modifier, elemento: String){
    Row(
        content = {Text(elemento)},
        modifier = modifier
    )

}

}