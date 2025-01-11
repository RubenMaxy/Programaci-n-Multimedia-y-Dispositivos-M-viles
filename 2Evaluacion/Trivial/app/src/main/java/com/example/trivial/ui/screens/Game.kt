package com.example.trivial.ui.screens

import android.annotation.SuppressLint
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
            Text(text= trivialState.listQuestions[trivialState.actualQuestion].question,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally))

            Respuestas(answers= trivialViewModel.getAnswer(trivialState.actualQuestion),
                isAnswer = { trivialViewModel.getIsAnswer() },
                onclick = { trivialViewModel.setAnswer() })

            Text(text= trivialViewModel.getText(),
                Modifier.clickable (enabled = !trivialViewModel.getIsAnswer(),
                    onClick = { if (it.equals("Ir a la puntuación")) navigateToEndGame else trivialViewModel.getNext()}))
        }
    }
}


@Composable
fun Respuestas(answers:List<String>,
               isAnswer:()->Boolean,
               onclick:()->Unit,
               ){
    Button (onClick = onclick,
        enabled = isAnswer(),
        ) {
        Text(answers[0])
    }

    Button (onClick = onclick,
        enabled = isAnswer(),
    ){
        Text(answers[1])
    }

    Button (onClick = onclick,
        enabled = isAnswer(),
        ){
        Text(answers[2])
    }

    Button (onClick = onclick,
        enabled = isAnswer(),
        ){
        Text(answers[3])
    }
}