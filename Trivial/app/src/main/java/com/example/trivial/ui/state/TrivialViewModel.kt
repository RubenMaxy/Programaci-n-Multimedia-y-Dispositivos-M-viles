package com.example.trivial.ui.state

import androidx.lifecycle.ViewModel
import com.example.trivial.model.getRandomQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TrivialViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TrivialUiState())
    val uiState: StateFlow<TrivialUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = TrivialUiState()
    }

    fun getQuestions(number: Int =_uiState.value.numberQuestions){
        _uiState.value = _uiState.value.copy(listQuestions=(getRandomQuestions(number)))
    }

    fun answer(){

    }

    fun getIsAnswer(): Boolean {
        return !_uiState.value.isAnswer
    }

}