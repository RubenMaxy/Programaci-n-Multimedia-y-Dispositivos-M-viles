package com.example.starwars.ui.network.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://swapi.info/api/" // URL base de la API, no olvidarse del http/https y la / del final

    val apiPersonajes: PersonajesApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Define la URL principal de la API
            .addConverterFactory(GsonConverterFactory.create()) // Convierte JSON en objetos de Kotlin
            .build()
            .create(PersonajesApi::class.java) // Vincula la interfaz con Retrofit
    }

    val apiPeliculas: PeliculasApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PeliculasApi::class.java)
    }
}
