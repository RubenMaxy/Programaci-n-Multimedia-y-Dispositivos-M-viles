package com.example.starwars.ui.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.example.starwars.ui.room.entidades.Favorito

@Dao
interface FavoritosDao {
    @Insert
    suspend fun agregarFavorito(favorito: Favorito)

    @Delete
    suspend fun eliminarFavorito(favorito: Favorito)

    @Query("SELECT * FROM favoritos")
    suspend fun obtenerFavoritos(): List<Favorito>
}