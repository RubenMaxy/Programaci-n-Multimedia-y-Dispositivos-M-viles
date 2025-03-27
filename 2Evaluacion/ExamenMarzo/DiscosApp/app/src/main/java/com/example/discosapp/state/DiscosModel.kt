package com.example.discosapp.state


import androidx.lifecycle.ViewModel
import com.example.discosapp.data.Disco
import com.example.discosapp.data.startingDiscos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DiscosModel : ViewModel() {

    private val _uiState = MutableStateFlow(ViewModelState())
    val uiState: StateFlow<ViewModelState> = _uiState.asStateFlow()

    init {
        setDiscosIniciales()
    }

    fun setDiscosIniciales(){
        _uiState.value = _uiState.value.copy(discos=startingDiscos)
    }
    fun deleteDisco(disco: Disco){
        _uiState.value=_uiState.value.copy(discos = _uiState.value.discos - disco)
    }

    fun getSelectedDisco(disco: Disco): String {
        return "Título: ${disco.titulo} \nAutor: ${disco.autor}\nNúmero de canciones: ${disco.numCanciones}" +
                "\nAño de publicación: ${disco.publicacion} \nValoración: ${disco.valoracion}"
    }
}