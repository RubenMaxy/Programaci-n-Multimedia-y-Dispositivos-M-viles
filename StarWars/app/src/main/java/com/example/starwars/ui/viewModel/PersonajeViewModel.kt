package com.example.starwars.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.ui.modelo.Pelicula
import com.example.starwars.ui.modelo.Personaje
import com.example.starwars.ui.network.api.RetrofitClient
import com.example.starwars.ui.room.dao.FavoritosDao
import com.example.starwars.ui.room.entidades.Favorito
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.starwars.ui.modelo.toFavorito // Importar la extensión para usarla

class PersonajeViewModel(private val favoritosDao: FavoritosDao) : ViewModel() {

    private val _personajes = MutableStateFlow<List<Personaje>>(emptyList())
    val personajes: StateFlow<List<Personaje>> = _personajes

    private val _personajeSeleccionado = MutableStateFlow<Personaje?>(null)
    val personajeSeleccionado: StateFlow<Personaje?> = _personajeSeleccionado

    private val _peliculas = MutableStateFlow<List<Pelicula>>(emptyList())
    val peliculas: StateFlow<List<Pelicula>> = _peliculas

    private val _favoritos = MutableStateFlow<List<Favorito>>(emptyList())
    val favoritos: StateFlow<List<Favorito>> = _favoritos

    fun cargarPersonajes() {
        viewModelScope.launch {
            try {
                _personajes.value = RetrofitClient.apiPersonajes.getPersonajes()
                cargarFavoritos() // ✅ Carga los favoritos al mismo tiempo
            } catch (e: Exception) {
                Log.e("PersonajeViewModel", "Error al obtener personajes: ${e.message}")
            }
        }
    }

    fun seleccionarPersonaje(personaje: Personaje) {
        _personajeSeleccionado.value = personaje // ✅ Guarda el personaje seleccionado
        cargarPeliculas(personaje.peliculas) // ✅ Carga las películas asociadas
    }

    fun cargarPeliculas(peliculasUrls: List<String>) {
        viewModelScope.launch {
            try {
                val peliculasCargadas = peliculasUrls.mapNotNull { url ->
                    val id = url.split("/").lastOrNull() ?: return@mapNotNull null // ✅ Manejo seguro del ID
                    RetrofitClient.apiPeliculas.getPelicula(id) // ✅ Llamada a la API
                }
                _peliculas.value = peliculasCargadas // ✅ Actualizamos el estado con los datos obtenidos
            } catch (e: Exception) {
                _peliculas.value = emptyList() // Evita estados inconsistentes
                Log.e("PersonajeViewModel", "Error al obtener películas: ${e.message}")
            }
        }
    }

    fun cargarFavoritos() {
        viewModelScope.launch {
            try {
                _favoritos.value = favoritosDao.obtenerFavoritos() // ✅ Carga los favoritos desde Room
            } catch (e: Exception) {
                Log.e("PersonajeViewModel", "Error al obtener favoritos: ${e.message}")
            }
        }
    }

    fun alternarFavorito(personaje: Personaje) {
        viewModelScope.launch {
            val esFavorito = _favoritos.value.any { it.nombre == personaje.nombre }
            if (esFavorito) {
                favoritosDao.eliminarFavorito(personaje.toFavorito()) // ✅ Eliminamos en la base de datos
                _favoritos.value = _favoritos.value.filter { it.nombre != personaje.nombre } // ✅ Eliminamos localmente
            } else {
                favoritosDao.agregarFavorito(personaje.toFavorito()) // ✅ Agregamos en la base de datos
                _favoritos.value = _favoritos.value + personaje.toFavorito() // ✅ Agregamos localmente
            }
        }
    }
}


