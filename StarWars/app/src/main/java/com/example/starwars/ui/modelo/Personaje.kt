package com.example.starwars.ui.modelo

import com.google.gson.annotations.SerializedName


data class Personaje(
    @SerializedName("name") val nombre: String, // Nombre del personaje, si se llama igual no haria falta el SerializedName
    @SerializedName("height") val altura: String, // Altura en cm
    @SerializedName("hair_color") val colorPelo: String,    // Color de pelo
    @SerializedName("birth_year") val nacimiento: String,   // Año de nacimiento
    @SerializedName("films") val peliculas: List<String> // Lista de películas en las que aparece
)


