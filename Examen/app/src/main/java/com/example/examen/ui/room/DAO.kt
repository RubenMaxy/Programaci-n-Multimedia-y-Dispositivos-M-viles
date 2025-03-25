package com.example.examen.ui.room

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
