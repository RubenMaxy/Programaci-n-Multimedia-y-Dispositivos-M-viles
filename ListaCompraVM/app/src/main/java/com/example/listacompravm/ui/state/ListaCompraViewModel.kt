package com.example.listacompravm.ui.state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.listacompravm.model.ProductInitial
import com.example.listacompravm.model.getListaCompra

class ListaCompraViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(ListaCompraState())
    val uiState: StateFlow<ListaCompraState> = _uiState.asStateFlow()

    init {
        _uiState.value = ListaCompraState(getListaCompra().toMutableList())
    }

    fun toggleChecked(item: ProductInitial) {
        _uiState.value = _uiState.value.copy(lista = _uiState.value.lista.toMutableStateList().apply {
            find { it.name == item.name }?.checked = !item.checked
        })
        isSomethingChecked() // Check if there is something checked
    }

    fun remove(item: ProductInitial) {
        _uiState.value = _uiState.value.copy(lista = _uiState.value.lista.toMutableStateList().apply { remove(item) })
    }

    // Add a new product to the list if it is not already there
    fun add(name: String) = if (_uiState.value.lista.find { it.name == name } == null) {
        _uiState.value = _uiState.value.copy(lista = _uiState.value.lista.toMutableStateList().apply { add(0, ProductInitial(name)) })
        true
    } else {
        false
    }

    fun changingNewProduct(newProduct: String) {
        _uiState.value = _uiState.value.copy(newProduct = newProduct)
    }

    fun deleteAllChecked() {
        _uiState.value = _uiState.value.copy(lista = _uiState.value.lista.toMutableStateList().apply {
            removeAll { it.checked }
        })
        isSomethingChecked() // Check if there is something checked
    }

    private fun isSomethingChecked() {
        _uiState.value = _uiState.value.copy(somethingChecked = _uiState.value.lista.any { it.checked })
    }
}