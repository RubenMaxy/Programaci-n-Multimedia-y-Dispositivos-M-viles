package com.example.starwars.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwars.ui.room.dao.FavoritosDao

class PersonajeViewModelFactory(private val favoritosDao: FavoritosDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonajeViewModel::class.java)) {
            return PersonajeViewModel(favoritosDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

