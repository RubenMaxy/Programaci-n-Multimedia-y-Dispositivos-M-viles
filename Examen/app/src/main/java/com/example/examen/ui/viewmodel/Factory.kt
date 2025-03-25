package com.example.examen.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MultiViewModelFactory(
    private val firstRepository: FirstRepository,
    private val secondRepository: SecondRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FirstViewModel::class.java) -> {
                FirstViewModel(firstRepository) as T
            }
            modelClass.isAssignableFrom(SecondViewModel::class.java) -> {
                SecondViewModel(secondRepository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
