package com.example.trivial.ui.state

import com.example.trivial.data.QuestionData
import com.example.trivial.model.Questions

data class TrivialUiState(
    val numberQuestions: Int=5,
    val record:Int=0,
    val listQuestions: List<QuestionData> = emptyList(),
    val correctPercent: Int =0,
    val isAnswer: Boolean = false
    )
