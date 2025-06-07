package com.example.starwars.ui.room.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritos")
data class Favorito(
    @PrimaryKey val nombre: String, // Usamos el nombre como clave única
    val altura: String,
    val colorPelo: String,
    val nacimiento: String
)
