package com.example.starwars.ui.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.ui.data.modelo.Personaje
import com.example.starwars.ui.network.api.RetrofitClient
import com.example.starwars.ui.room.dao.FavoritosDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.starwars.ui.data.modelo.toFavorito // Importar la extensión para usarla

class PersonajeViewModel(private val favoritosDao: FavoritosDao) : ViewModel() {
    private val _uiState = MutableStateFlow(PersonajeUiState())
    val uiState: StateFlow<PersonajeUiState> = _uiState

    fun cargarPersonajes() {
        viewModelScope.launch {
            try {
                val personajes = RetrofitClient.apiPersonajes.getPersonajes()
                _uiState.value = _uiState.value.copy(personajes = personajes, cargando = false)
                cargarFavoritos() // Cargar favoritos después de los personajes
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Error al obtener personajes", cargando = false)
            }
            _uiState.value = _uiState.value.copy(cargando = false) // Indicamos que la carga finalizó
        }
    }

    fun seleccionarPersonaje(personaje: Personaje) {
        _uiState.value = _uiState.value.copy(personajeSeleccionado = personaje)
        cargarPeliculas(personaje.peliculas)
    }

    fun cargarPeliculas(peliculasUrls: List<String>) {
        viewModelScope.launch {
            try {
                val peliculasCargadas = peliculasUrls.mapNotNull { url ->
                    val id = url.split("/").lastOrNull()
                    RetrofitClient.apiPeliculas.getPelicula(id.toString())
                }
                _uiState.value = _uiState.value.copy(peliculas = peliculasCargadas)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Error al obtener películas")
            }
        }
    }

    fun cargarFavoritos() {
        viewModelScope.launch {
            try {
                val favoritos = favoritosDao.obtenerFavoritos()
                _uiState.value = _uiState.value.copy(favoritos = favoritos)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Error al obtener favoritos")
            }
        }
    }

    fun alternarFavorito(personaje: Personaje) {
        viewModelScope.launch {
            val esFavorito = _uiState.value.favoritos.any { it.nombre == personaje.nombre }
            if (esFavorito) {
                favoritosDao.eliminarFavorito(personaje.toFavorito())
                _uiState.value = _uiState.value.copy(favoritos = _uiState.value.favoritos.filter { it.nombre != personaje.nombre })
            } else {
                favoritosDao.agregarFavorito(personaje.toFavorito())
                _uiState.value = _uiState.value.copy(favoritos = _uiState.value.favoritos + personaje.toFavorito())
            }
        }
    }
}