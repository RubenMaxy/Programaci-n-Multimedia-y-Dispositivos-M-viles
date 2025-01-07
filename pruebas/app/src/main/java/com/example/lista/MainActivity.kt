package com.example.lista

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lista.ui.theme.ListaTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val lista= listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50)
            ListaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .padding(top=50.dp)) {
                    Greeting(lista = lista)
                }
            }
        }
    }
}

@Composable
fun Greeting(lista: List<Int>, modifier: Modifier = Modifier.padding(15.dp)) {
    LazyColumn(modifier=Modifier.padding(start=10.dp)) {
        items(lista){
            Text("Item Nº $it")
            Spacer(modifier = Modifier.fillMaxSize()
                .padding(vertical = 1.dp))
        }
    }
}