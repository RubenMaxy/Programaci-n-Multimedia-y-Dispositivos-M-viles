package com.example.starwars.ui.viewModel

import com.example.starwars.ui.data.modelo.Pelicula
import com.example.starwars.ui.data.modelo.Personaje
import com.example.starwars.ui.room.entidades.Favorito

data class PersonajeUiState(
    val personajes: List<Personaje> = emptyList(),
    val personajeSeleccionado: Personaje? = null,
    val peliculas: List<Pelicula> = emptyList(),
    val favoritos: List<Favorito> = emptyList(),
    val cargando: Boolean = true,
    val error: String? = null
)
