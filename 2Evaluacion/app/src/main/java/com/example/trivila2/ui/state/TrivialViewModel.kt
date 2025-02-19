package com.example.trivila2.ui.state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.trivila2.model.getRandomQuestions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TrivialViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TrivialUiState())
    val uiState: StateFlow<TrivialUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = TrivialUiState()
        //getQuestions() //Solo es necesario cuando quiero iniciar en la pantalla GAME
    }

    fun getQuestions(){
        _uiState.value = _uiState.value.copy(listQuestions=(getRandomQuestions(_uiState.value.numberQuestions)).toMutableStateList(), valorPercent = (100/_uiState.value.numberQuestions).toDouble())
    }

    fun getAnswer(pregunta: Int): List<String> {
        return _uiState.value.listQuestions[pregunta].answers
    }

    fun getIsAnswer(): Boolean {
        return !_uiState.value.isAnswer
    }

    fun setAnswer() {
        _uiState.value=_uiState.value.copy(isAnswer = !_uiState.value.isAnswer)
    }

    fun getText(): String {
        if(_uiState.value.actualQuestion==_uiState.value.numberQuestions-1){
            return "Ir a la puntuación"
        } else if(_uiState.value.actualQuestion<_uiState.value.numberQuestions-1){
            return "Siguiente pregunta"
        } else return "Ir a la puntuación"
    }
    fun getNext() {
        _uiState.value=_uiState.value.copy(actualQuestion = _uiState.value.actualQuestion+1)
        if(_uiState.value.isCorrect){
            _uiState.value=_uiState.value.copy(isCorrect = !_uiState.value.isCorrect)
        }
        setAnswer()
    }

    fun getIsCorrect(option: Int) {
        if( _uiState.value.listQuestions[_uiState.value.actualQuestion].correctAnswerIndex==option){
            _uiState.value=_uiState.value.copy(correctPercent = _uiState.value.correctPercent + _uiState.value.valorPercent, isCorrect = !_uiState.value.isCorrect)
        }
    }

    fun setSelectedOption(option: Int) {
        _uiState.value=_uiState.value.copy(selectedOption = option)
    }

    fun getNumberQuestions(): Int {
        return _uiState.value.numberQuestions
    }
    fun setNumberQuestions(number: Int) {
        _uiState.value=_uiState.value.copy(numberQuestions = number)
    }

    fun setPercent(percent: Double) {
        _uiState.value=_uiState.value.copy(correctPercent = percent)

    }
}