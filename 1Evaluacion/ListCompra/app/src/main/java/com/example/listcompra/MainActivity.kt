package com.example.listcompra



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listcompra.ui.theme.ListCompraTheme

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
                //Spacer(Modifier.height(150.dp))
                lista(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    listaCompra = listaCompra
                )
            
        }
    }
}
@Composable
fun anadir(modifier: Modifier = Modifier, listaCompra: MutableList<String>) {
    Row(modifier = modifier) {
        TextField(
            value="",
            onValueChange = {})
        IconButton(onClick = {} ){
            Icon (Icons.Default.ShoppingCart, contentDescription = "Añadir a la lista")
        }
    }
}

@Composable
fun lista(modifier: Modifier=Modifier, listaCompra:MutableList<String>){
    LazyColumn {
       //items(listaCompra.size){ index ->     Text(text =(listaCompra.get(index)) ,modifier=modifier)    }
        items(listaCompra.size) { index ->
            elementosLista(modifier, elemento = listaCompra.get(index))
        }
    }
}

@Composable
fun elementosLista(modifier: Modifier=Modifier, elemento: String){
    Text(text =elemento ,modifier=modifier)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val listaCompra by remember { mutableStateOf(mutableListOf("Tomates", "Manzanas")) }
    Column {
        anadir(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp), listaCompra
        )
        //Spacer(Modifier.height(5.dp))
        lista(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            listaCompra = listaCompra
        )
    }
}
}