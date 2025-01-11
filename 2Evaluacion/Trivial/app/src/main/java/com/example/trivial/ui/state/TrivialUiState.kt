package com.example.trivial.ui.state

import com.example.trivial.data.QuestionData


data class TrivialUiState(
    val numberQuestions: Int=5,
    val actualQuestion: Int=0,
    val record:Int=0,
    val listQuestions: List<QuestionData> = emptyList(),
    val correctPercent: Double =0.0,
    val isAnswer: Boolean = false,
    val valorPercent: Double =0.0,
    val isCorrect: Boolean = false
    )
