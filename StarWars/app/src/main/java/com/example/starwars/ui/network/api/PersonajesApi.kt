package com.example.starwars.ui.network.api


import com.example.starwars.ui.modelo.Personaje
import retrofit2.http.GET

interface PersonajesApi {
    @GET("people") // Endpoint donde se obtienen los personajes
    suspend fun getPersonajes(): List<Personaje> // Devuelve una lista de personajes
}
