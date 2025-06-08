package com.example.starwars.ui.modelo


import com.example.starwars.ui.room.entidades.Favorito
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Personaje(
    @SerializedName("name") val nombre: String, // Nombre del personaje, si se llama igual no haria falta el SerializedName
    @SerializedName("height") val altura: String, // Altura en cm
    @SerializedName("hair_color") val colorPelo: String,    // Color de pelo
    @SerializedName("birth_year") val nacimiento: String,   // Año de nacimiento
    @SerializedName("films") val peliculas: List<String> // Lista de películas en las que aparece
) : Serializable

fun Personaje.toFavorito(): Favorito {
    return Favorito(
        nombre = this.nombre,
        altura = this.altura,
        colorPelo = this.colorPelo,
        nacimiento = this.nacimiento,
        peliculas = this.peliculas // ✅ Mantiene la lista de películas correctamente
    )
}

