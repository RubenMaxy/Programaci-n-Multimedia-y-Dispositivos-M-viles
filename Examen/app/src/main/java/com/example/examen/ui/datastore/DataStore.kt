package com.example.examen.ui.datastore

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "app_preferences")


private val USER_NAME_KEY = stringPreferencesKey("user_name")

suspend fun saveUserName(context: Context, userName: String) {
    context.dataStore.edit { preferences ->
        preferences[USER_NAME_KEY] = userName
    }
}

fun getUserName(context: Context): Flow<String?> {
    return context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY]
    }
}



@Composable
fun DataStoreScreen(context: Context) {
    val scope = rememberCoroutineScope()
    val userNameFlow = getUserName(context)
    val userName by userNameFlow.collectAsState(initial = "Sin nombre")
    var newUserName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Nombre de usuario actual: $userName")

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = newUserName,
            onValueChange = { newUserName = it },
            label = { Text("Introduce un nuevo nombre") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                saveUserName(context, newUserName)
            }
        }, enabled = newUserName.isNotEmpty()) {
            Text("Guardar nombre")
        }
    }
}
