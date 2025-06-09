package com.example.starwars.ui.network.api

import com.example.starwars.ui.data.modelo.Pelicula
import retrofit2.http.GET
import retrofit2.http.Path

interface PeliculasApi {
    @GET("films/{id}") // La API devuelve detalles de una película específica
    suspend fun getPelicula(@Path("id") id: String): Pelicula
}
