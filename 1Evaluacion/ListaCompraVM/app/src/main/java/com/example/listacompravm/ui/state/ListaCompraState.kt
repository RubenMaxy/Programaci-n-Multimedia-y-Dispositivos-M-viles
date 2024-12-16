package com.example.listacompravm.ui.state

import com.example.listacompravm.model.ProductInitial

data class ListaCompraState(
    val lista: List<ProductInitial> = emptyList(),
    val newProduct: String = "",
    val somethingChecked: Boolean = false,
)