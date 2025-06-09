package com.example.discos.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.discos.ui.data.Discos
import com.example.discos.ui.room.dao.DiscosDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DiscoViewModel(private val discoDao: DiscosDao) : ViewModel() {
    private val _uiState = MutableStateFlow(DiscoUiState())
    val uiState: StateFlow<DiscoUiState> = _uiState

    init {
        cargarDiscos()
    }

    fun cargarDiscos() {
        viewModelScope.launch {
            val discos = discoDao.obtenerTodosLosDiscos()
            _uiState.value = _uiState.value.copy(discos = discos)
        }
    }

    fun agregarDisco(disco: Discos) {
        viewModelScope.launch {
            discoDao.insertarDisco(disco)
            cargarDiscos() // Refresca la lista tras agregar
        }
    }

    fun eliminarDisco(disco: Discos) {
        viewModelScope.launch {
            discoDao.eliminarDisco(disco)
            cargarDiscos() // Refresca la lista tras eliminar
        }
    }

    fun calcularPromedioValoracion(): Float {
        val discos = _uiState.value.discos
        return if (discos.isNotEmpty()) {
            discos.map { it.valoracion }.average().toFloat()
        } else 0f
    }
}
