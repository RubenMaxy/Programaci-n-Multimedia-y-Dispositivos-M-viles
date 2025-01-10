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
        getQuestions()
    }

    fun getQuestions(number: Int =_uiState.value.numberQuestions){
        _uiState.value = _uiState.value.copy(listQuestions=(getRandomQuestions(number)))
    }

    fun getAnswer(pregunta: Int): List<String> {
        return _uiState.value.listQuestions[pregunta].answers
    }

    fun getIsAnswer(): Boolean {
        return !_uiState.value.isAnswer
    }

    fun setAnswer() {
        if(_uiState.value.actualQuestion<_uiState.value.numberQuestions){
            _uiState.value=_uiState.value.copy(isAnswer = !_uiState.value.isAnswer)
        } else{
            getNext()
        }
    }

    fun getNext(): String {
        if(_uiState.value.actualQuestion==_uiState.value.numberQuestions){
            return "Ir a la puntuación"
        } else{
            _uiState.value=_uiState.value.copy(numberQuestions = _uiState.value.actualQuestion+1)
            return "Siguiente pregunta"
        }
    }

}