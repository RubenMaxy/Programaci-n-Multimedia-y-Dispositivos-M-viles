package com.example.discos.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discos.ui.data.Discos
import com.example.discos.ui.room.dao.DiscosDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.discos.ui.data.startingDiscos
import java.lang.Thread.sleep


class DiscoViewModel(private val discoDao: DiscosDao) : ViewModel() {
    private val _uiState = MutableStateFlow(DiscoUiState())
    val uiState: StateFlow<DiscoUiState> = _uiState

    init {
        cargarDiscos()
    }

    fun cargarDiscos() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(cargando = true) // Indicamos que estamos cargando
            try {
                val discos = discoDao.obtenerTodosLosDiscos()
                _uiState.value = _uiState.value.copy(discos = discos, cargando = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Error al obtener discos", cargando = false)
            }
        }
    }

    fun calcularPromedioValoracion(): Float {
        val discos = _uiState.value.discos
        return if (discos.isNotEmpty()) {
            discos.map { it.valoracion }.average().toFloat()
        } else 0f
    }

    fun actualizarTitulo(nuevoTitulo: String) {
        _uiState.value = _uiState.value.copy(titulo = nuevoTitulo)
    }

    fun actualizarAutor(nuevoAutor: String) {
        _uiState.value = _uiState.value.copy(autor = nuevoAutor)
    }

    fun actualizarNumCanciones(nuevoNum: String) {
        _uiState.value = _uiState.value.copy(numCanciones = nuevoNum)
    }

    fun actualizarPublicacion(nuevoAnio: String) {
        _uiState.value = _uiState.value.copy(publicacion = nuevoAnio)
    }

    fun actualizarValoracion(nuevaValoracion: String) {
        _uiState.value = _uiState.value.copy(valoracion = nuevaValoracion)
    }

    fun agregarDisco() {
        val nuevoDisco = Discos(
            titulo = _uiState.value.titulo,
            autor = _uiState.value.autor,
            numCanciones = _uiState.value.numCanciones.toInt(),
            publicacion = _uiState.value.publicacion.toInt(),
            valoracion = _uiState.value.valoracion.toInt()
        )
        viewModelScope.launch {
            discoDao.insertarDisco(nuevoDisco)
            cargarDiscos() // Actualizamos la lista
        }
    }

    fun cargarDiscosPorDefecto() {
        viewModelScope.launch {
            val discosPorDefecto = startingDiscos // Obtiene los discos de la data class
            discosPorDefecto.forEach { discoDao.insertarDisco(it) } // Guarda en la BD
            cargarDiscos() // Actualiza la lista en la UI
        }
    }

    fun seleccionarDiscoParaEliminar(disco: Discos) {
        _uiState.value = _uiState.value.copy(discoAEliminar = disco)
    }

    fun cancelarEliminacion() {
        _uiState.value = _uiState.value.copy(discoAEliminar = null)
    }

    fun confirmarEliminacion() {
        _uiState.value.discoAEliminar?.let { disco ->
            viewModelScope.launch {
                discoDao.eliminarDisco(disco)
                cargarDiscos() // Refresca la lista tras eliminar
            }
            _uiState.value = _uiState.value.copy(discoAEliminar = null) // Limpia el estado
        }
    }
}