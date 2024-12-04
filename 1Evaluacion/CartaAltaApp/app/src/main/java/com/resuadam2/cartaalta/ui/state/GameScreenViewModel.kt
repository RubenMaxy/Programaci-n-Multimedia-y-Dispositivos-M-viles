package com.resuadam2.cartaalta.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameScreenViewModel : ViewModel() {
    val _state = MutableStateFlow(GameScreenState())
    val state : StateFlow<GameScreenState> = _state.asStateFlow()

    fun jugador1Tira() {
        _state.value = _state.value.copy(jugador1Carta = (1..2).random())
        _state.value = _state.value.copy(jugador1HaTirado = true)
        ganadorEs()
    }

    fun jugador2Tira() {
        _state.value = _state.value.copy(jugador2Carta = (1..2).random())
        _state.value = _state.value.copy(jugador2HaTirado = true)
        ganadorEs()
    }

    fun todosHanTirado() = _state.value.jugador1HaTirado && _state.value.jugador2HaTirado

    private fun ganadorEs() {
        if (todosHanTirado()){
            if (_state.value.jugador1Carta == _state.value.jugador2Carta) {
                _state.value = _state.value.copy(ganador = "Empate")
                return
            }
            val jugador = if (_state.value.jugador1Carta > _state.value.jugador2Carta) 1 else 2
            _state.value = _state.value.copy(ganador = "Jugador $jugador")
        }
    }
}