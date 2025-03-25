package com.example.preparacionexamen.ui.navigation;

import androidx.compose.runtime.Composable;
import androidx.navigation.compose.NavHost;
import androidx.navigation.compose.composable;
import androidx.navigation.compose.rememberNavController;

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "pantalla1") {
        composable("pantalla1") {
            Pantalla1 { userInput ->
                    navController.navigate("pantalla2/$userInput")
            }
        }
        composable("pantalla2/{input}") { backStackEntry ->
                val input = backStackEntry.arguments?.getString("input") ?: "Sin valor"
            Pantalla2(input)
        }
    }
}

@Composable
fun Pantalla1(onNavigateToPantalla2: (String) -> Unit) {
var userInput by remember { mutableStateOf("") }

Column {
    // Campo de texto para que el usuario introduzca un valor
    TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Introduce un valor") }
    )
    // Botón para navegar a Pantalla2 con el valor proporcionado por el usuario
    Button(
            onClick = { onNavigateToPantalla2(userInput) },
            enabled = userInput.isNotEmpty() // Asegurar que el campo no esté vacío
    ) {
        Text("Ir a Pantalla 2 con el valor: $userInput")
    }
}


@Composable
fun Pantalla2(input: String) {
    Text("Valor recibido: $input")
}

