package com.example.examen.ui.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val users = mutableListOf<User>()

    fun fetchUsers() {
        viewModelScope.launch {
            users.clear()
            users.addAll(repository.getAllUsers())
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    fun removeUser(user: User) {
        viewModelScope.launch {
            repository.deleteUser(user)
        }
    }
}