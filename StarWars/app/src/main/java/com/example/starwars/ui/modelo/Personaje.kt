package com.example.starwars.ui.modelo

import com.google.gson.annotations.SerializedName

data class Personaje(
    @SerializedName("name") val nombre: String, // Nombre del personaje, si las val se llaman igual no haria falta el SerializedName
    val imagenes: List<String>,  // Lista de URLs de imágenes
    val films: List<String>  // Lista de URLs de películas donde aparece el personaje
)

