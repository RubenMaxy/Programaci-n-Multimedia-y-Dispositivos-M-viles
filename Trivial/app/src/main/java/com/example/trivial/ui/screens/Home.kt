package com.example.trivial.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navigateToGame: () -> Unit,

) {
    Scaffold ( topBar={TopAppBar (title = { Text("Trivial VideoMax")},
        colors=TopAppBarDefaults.topAppBarColors(
            titleContentColor = Color.Green
        ))},
        modifier = Modifier) {

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement= Arrangement.Center){
            IconButton(onClick = {
                    //TODO()
                } ) {
                Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "Restar 1")
            }
            Text(text="")
            IconButton(onClick = {
                //TODO()
            } ) {
                Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "Sumar 1")
            }
        }

        Column (modifier = Modifier.fillMaxSize()){

        }

    }
}