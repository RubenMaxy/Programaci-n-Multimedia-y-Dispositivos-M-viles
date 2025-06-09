package com.example.discos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.discos.ui.navigation.AppNavigation
import com.example.discos.ui.room.dataBase.DiscosDatabase
import com.example.discos.ui.theme.DiscosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = DiscosDatabase.getDatabase(this) // Inicializa la base de datos
        val discoDao = db.discoDao() // Obtiene el DAO

        setContent {
            val navController = rememberNavController()
            AppNavigation(navController, discoDao) // Pasamos `discoDao` a la navegación
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiscosTheme {
        Greeting("Android")
    }
}