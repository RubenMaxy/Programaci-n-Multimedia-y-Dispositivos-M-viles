package com.example.starwars

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.starwars.ui.navigation.AppNavigation
import com.example.starwars.ui.theme.StarWarsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController() // Inicializa NavController

            StarWarsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AppNavigation(navController) // Se lo pasamos a la navegación
                }
            }
        }
    }
}