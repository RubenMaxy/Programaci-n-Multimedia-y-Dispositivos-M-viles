package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.lifecycle.ViewModelProvider
import com.example.examen.ui.viewmodel.FirstViewModel
import com.example.examen.ui.viewmodel.MultiViewModelFactory
import com.example.examen.ui.viewmodel.SecondViewModel
import androidx.compose.runtime.Composable
import com.example.examen.ui.room.User
import com.example.examen.ui.room.UserDao
import com.google.firebase.appdistribution.gradle.ApiService

class MainActivitySecond : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val firstRepository = FirstRepository()
        val secondRepository = SecondRepository()

        val factory = MultiViewModelFactory(firstRepository, secondRepository)

        // Crear instancias de los ViewModels
        val firstViewModel = ViewModelProvider(this, factory)[FirstViewModel::class.java]
        val secondViewModel = ViewModelProvider(this, factory)[SecondViewModel::class.java]

        setContent {
            MyScreen(firstViewModel, secondViewModel)
        }
    }
}

class FirstRepository(private val apiService: ApiService) {
    suspend fun getData(): String {
        return apiService.getDataFromApi()
    }
}

class SecondRepository(private val userDao: UserDao) {
    suspend fun getData(): List<User> {
        return userDao.getAllUsers()
    }
}

@Composable
fun MyScreen(
    firstViewModel: FirstViewModel,
    secondViewModel: SecondViewModel
) {
    val firstData = firstViewModel.getFirstData()
    val secondData = secondViewModel.getSecondData()

    Column {
        Text(text = "Datos del primer ViewModel: $firstData")
        Text(text = "Datos del segundo ViewModel: $secondData")
    }
}

