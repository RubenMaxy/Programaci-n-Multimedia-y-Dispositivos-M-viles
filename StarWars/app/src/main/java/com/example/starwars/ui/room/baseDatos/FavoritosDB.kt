package com.example.starwars.ui.room.baseDatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.room.entidades.Favorito


@Database(entities = [Favorito::class], version = 1)
abstract class FavoritosDB : RoomDatabase() {
    abstract fun favoritosDao(): FavoritosDao
}

