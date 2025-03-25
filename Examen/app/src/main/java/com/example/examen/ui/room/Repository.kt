package com.example.examen.ui.room

class UserRepository(private val userDao: UserDao) {
    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}
