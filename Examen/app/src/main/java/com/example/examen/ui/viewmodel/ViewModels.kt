package com.example.examen.ui.viewmodel

import androidx.lifecycle.ViewModel

class FirstViewModel(private val repository: FirstRepository) : ViewModel() {
    fun getFirstData() = repository.getData()
}

class SecondViewModel(private val repository: SecondRepository) : ViewModel() {
    fun getSecondData() = repository.getData()
}
