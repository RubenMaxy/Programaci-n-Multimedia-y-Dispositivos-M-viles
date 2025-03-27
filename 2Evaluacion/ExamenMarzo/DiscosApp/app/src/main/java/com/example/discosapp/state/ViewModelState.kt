package com.example.discosapp.state

import com.example.discosapp.data.Disco

data class ViewModelState(
    val discos:List<Disco> = emptyList()
)