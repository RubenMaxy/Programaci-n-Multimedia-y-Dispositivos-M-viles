package com.example.starwars.ui.network.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "swapi.info/api/" // URL base de la API

    val api: StarWarsApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Define la URL principal de la API
            .addConverterFactory(GsonConverterFactory.create()) // Convierte JSON en objetos de Kotlin
            .build()
            .create(StarWarsApi::class.java) // Vincula la interfaz con Retrofit
    }
}
