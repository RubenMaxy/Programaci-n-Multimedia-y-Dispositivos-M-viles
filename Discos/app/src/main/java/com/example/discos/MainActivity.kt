package com.example.discos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.discos.ui.navigation.AppNavigation
import com.example.discos.ui.room.dataBase.DiscosDatabase


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = DiscosDatabase.getDatabase(this) // Inicializa la base de datos
        val discoDao = db.discoDao() // Obtiene el DAO

        setContent {
            val navController = rememberNavController()
            AppNavigation(navController, discoDao) // Pasamos `discosDao` a la navegación
        }
    }
}