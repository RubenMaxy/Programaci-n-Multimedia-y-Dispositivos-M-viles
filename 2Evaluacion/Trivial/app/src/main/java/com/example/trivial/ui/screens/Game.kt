package com.example.trivial.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import com.example.trivial.ui.state.TrivialViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Game(
    navigateToEndGame: () ->Unit,
    trivialViewModel: TrivialViewModel = viewModel()
) {
    val trivialState by trivialViewModel.uiState.collectAsState()
    Scaffold (modifier = Modifier.padding(all=20.dp)){
        Column (modifier = Modifier){
            Text(text= "Puntuación: ${trivialState.correctPercent}%",
                modifier = Modifier
                    .align(Alignment.End))

            Text(text= trivialState.listQuestions[trivialState.actualQuestion].question,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally))

            Respuestas(answers= trivialViewModel.getAnswer(trivialState.actualQuestion),
                isAnswer = { trivialViewModel.getIsAnswer() },
                onclick = { trivialViewModel.setAnswer()
                          trivialViewModel.getIsCorrect(option = it)},
                color = {if(trivialState.isCorrect&&trivialState.isAnswer) ButtonDefaults.buttonColors(containerColor = Color.Green)
                        else if(trivialState.isAnswer)ButtonDefaults.buttonColors(containerColor = Color.Red)
                        else ButtonDefaults.buttonColors()}
                )

            Text(text= trivialViewModel.getText(),
                Modifier.clickable (enabled = !trivialViewModel.getIsAnswer(),
                    onClick = { if (it.equals("Ir a la puntuación")) navigateToEndGame else trivialViewModel.getNext()}))
        }
    }
}


@Composable
fun Respuestas(answers:List<String>,
               isAnswer:()->Boolean,
               onclick:(option:Int)->Unit,
               color: @Composable ()-> ButtonColors
               ){
    Button (onClick = { onclick(0) },
        enabled = isAnswer(),
        colors = color(),
        ) {
        Text(answers[0])
    }

    Button (onClick = { onclick(1) },
        enabled = isAnswer(),
        colors = color(),
        ) {
        Text(answers[1])
    }

    Button (onClick = { onclick(2) },
        enabled = isAnswer(),
        colors = color(),
        ){
        Text(answers[2])
    }

    Button (onClick = { onclick(3) },
        enabled = isAnswer(),
        colors = color(),
        ){
        Text(answers[3])
    }
}