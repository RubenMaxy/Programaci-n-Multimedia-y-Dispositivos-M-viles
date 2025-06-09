package com.example.starwars.ui.data.modelo

import com.google.gson.annotations.SerializedName

data class Pelicula(
    @SerializedName("title") val titulo: String,      // Título de la película
    @SerializedName("release_date") val estreno: String,     // Fecha de estreno
    @SerializedName("director") val director: String,    // Director de la película
    @SerializedName("opening_crawl") val descripcion: String  // Sinopsis o descripción
)
