package com.example.discos.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.discos.ui.room.dao.DiscosDao

class DiscoViewModelFactory(private val discoDao: DiscosDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiscoViewModel::class.java)) {
            return DiscoViewModel(discoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
