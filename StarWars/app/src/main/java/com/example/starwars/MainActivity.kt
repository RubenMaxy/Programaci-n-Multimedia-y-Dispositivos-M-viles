package com.example.starwars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.starwars.ui.dependencies.AppModule
import com.example.starwars.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppModule.provideDatabase(this) // Inicializa la BD
        val favoritosDao = db.favoritosDao() // Crea el DAO

        setContent {
            val navController = rememberNavController()
            AppNavigation(navController, favoritosDao) // Pasamos favoritosDao correctamente
        }
    }
}
