package com.example.discos.ui.viewModel

import com.example.discos.ui.data.Discos

data class DiscoUiState(
    val discos: List<Discos> = emptyList(),
    val titulo: String = "",
    val autor: String = "",
    val numCanciones: String = "",
    val publicacion: String = "",
    val valoracion: String = "",
    val cargando: Boolean = false,
    val error: String? = null,
    val discoAEliminar: Discos? = null
)

