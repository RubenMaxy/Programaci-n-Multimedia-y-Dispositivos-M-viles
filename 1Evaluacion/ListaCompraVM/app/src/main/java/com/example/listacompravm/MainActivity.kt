package com.example.listacompravm.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.listacompravm.ui.screens.MainScreen
import com.example.listacompravm.ui.theme.ListaCompraVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaCompraVMTheme {
                MainScreen()
            }
        }
    }
}