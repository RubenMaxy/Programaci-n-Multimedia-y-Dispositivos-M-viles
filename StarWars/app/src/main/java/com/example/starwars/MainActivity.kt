package com.example.starwars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.starwars.ui.dependencies.AppModule
import com.example.starwars.ui.navigation.AppNavigation
import com.example.starwars.ui.room.baseDatos.AppDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(this) // Inicializa la BD correctamente
        val favoritosDao = db.favoritosDao() // Obtiene el DAO correctamente

        setContent {
            val navController = rememberNavController()
            AppNavigation(navController, favoritosDao) // Pasa `favoritosDao` correctamente
        }
    }
}
