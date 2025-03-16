package com.example.trivila2.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trivila2.ui.state.TrivialViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Game(
    trivialViewModel: TrivialViewModel = viewModel()
) {
    val trivialState by trivialViewModel.uiState.collectAsState()

    Scaffold (modifier = Modifier.padding(all=20.dp)){
        Column (modifier = Modifier){
            Text(text= "Pregunta  ${trivialState.actualQuestion+1} de ${trivialState.numberQuestions}",
                modifier = Modifier
                    .align(Alignment.End))

            Text(text= trivialState.listQuestions[trivialState.actualQuestion].question,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally))

            Respuestas(
                answers = trivialViewModel.getAnswer(trivialState.actualQuestion),
                isAnswer = { trivialViewModel.getIsAnswer() },
                onclick = { trivialViewModel.setAnswer()
                    trivialViewModel.getIsCorrect(option = it)
                    trivialViewModel.setSelectedOption(option = it)},
                color = {if(trivialState.isCorrect&&trivialState.isAnswer&&it==trivialState.selectedOption)
                    Color.Green
                else if(trivialState.isAnswer&&!trivialState.isCorrect&&it==trivialState.selectedOption)
                    Color.Red
                else Color.Unspecified}
            )

            Text(text= trivialViewModel.getText(),
                Modifier.clickable (enabled = !trivialViewModel.getIsAnswer(),
                    onClick = { if (trivialViewModel.getText().equals("Ir a la puntuación")) trivialViewModel.navigateToEndGame()
                    else trivialViewModel.getNext()}))
        }
    }
}


@Composable
fun Respuestas(
    answers:List<String>,
    isAnswer:()->Boolean,
    onclick:(option:Int)->Unit,
    color: (selectedOption:Int) -> Color
){
    Button (onClick = { onclick(0) },
        enabled = isAnswer(),
        modifier = Modifier.background(color(0)),
    ) {
        Text(answers[0])
    }

    Button (onClick = { onclick(1) },
        enabled = isAnswer(),
        modifier = Modifier.background(color(1)),
    ) {
        Text(answers[1])
    }

    Button (onClick = { onclick(2) },
        enabled = isAnswer(),
        modifier = Modifier.background(color(2)),
    ){
        Text(answers[2])
    }

    Button (onClick = { onclick(3) },
        enabled = isAnswer(),
        modifier = Modifier.background(color(3)),
    ){
        Text(answers[3])
    }
}