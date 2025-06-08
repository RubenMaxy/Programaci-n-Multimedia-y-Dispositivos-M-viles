package com.example.starwars.ui.room.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.starwars.ui.modelo.Personaje

@Entity(tableName = "favoritos")
data class Favorito(
    @PrimaryKey val nombre: String,
    val altura: String,
    val colorPelo: String,
    val nacimiento: String,
    val peliculas: List<String>
)

fun Favorito.toPersonaje(): Personaje {
    return Personaje(
        nombre = this.nombre,
        altura = this.altura,
        colorPelo = this.colorPelo,
        nacimiento = this.nacimiento,
        peliculas = this.peliculas
    )
}





