package com.example.discos.ui.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.example.discos.ui.data.Discos

@Dao
interface DiscosDao {
    @Query("SELECT * FROM Discos")
    suspend fun obtenerTodosLosDiscos(): List<Discos> // Obtiene todos los discos

    @Insert
    suspend fun insertarDisco(disco: Discos) // Inserta un nuevo disco

    @Delete
    suspend fun eliminarDisco(disco: Discos) // Elimina un disco específico

    @Query("SELECT AVG(valoracion) FROM Discos")
    suspend fun obtenerPromedioValoracion(): Float? // Calcula el promedio de valoración
}
