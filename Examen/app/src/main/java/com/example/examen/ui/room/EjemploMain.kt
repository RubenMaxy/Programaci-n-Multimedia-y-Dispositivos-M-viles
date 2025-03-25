package com.example.examen.ui.room
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import kotlinx.coroutines.launch

@Composable
fun UserScreen(viewModel: UserViewModel) {
    val scope = rememberCoroutineScope()
    var userName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = userEmail,
            onValueChange = { userEmail = it },
            label = { Text("Email de usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                val user = User(name = userName, email = userEmail)
                viewModel.addUser(user)
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Guardar Usuario")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            viewModel.users.forEach { user ->
                item {
                    Text("ID: ${user.id}, Nombre: ${user.name}, Email: ${user.email}")
                }
            }
        }
    }
}
