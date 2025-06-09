package com.example.discos.ui.viewModel

import com.example.discos.ui.data.Discos

data class DiscoUiState(
    val discos: List<Discos> = emptyList(), // Lista de discos
    val cargando: Boolean = false, // Indicador de carga
    val error: String? = null // Manejo de errores
)
