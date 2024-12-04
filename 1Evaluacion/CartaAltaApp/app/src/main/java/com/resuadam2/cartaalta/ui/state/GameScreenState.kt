package com.resuadam2.cartaalta.ui.state

data class GameScreenState (
    val jugador1HaTirado: Boolean = false,
    val jugador2HaTirado: Boolean = false,
    val todosHanTirado: Boolean = false,
    val jugador1Carta: Int = 0,
    val jugador2Carta: Int = 0,
    val ganador: String = ""
)
