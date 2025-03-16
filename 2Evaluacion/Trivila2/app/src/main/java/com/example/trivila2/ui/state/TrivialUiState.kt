package com.example.trivila2.ui.state

import com.example.trivila2.data.QuestionData

data class TrivialUiState(
    val screen: Enum<Pantallas> =Pantallas.HOME,
    val numberQuestions: Int=5,
    val actualQuestion: Int=0,
    val record:Int=0,
    val listQuestions: List<QuestionData> = emptyList(),
    val correctPercent: Double =0.0,
    val isAnswer: Boolean = false,
    val valorPercent: Double =0.0,
    val isCorrect: Boolean = false,
    val selectedOption: Int = -1,
)