package com.luisdpc.discosappluis.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Disco(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val autor: String,
    val numCanciones: Int,
    val publicacion: Int,
    val valoracion: Int
)
