package com.example.discos.ui.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Discos(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val autor: String,
    val numCanciones: Int,
    val publicacion: Int,
    val valoracion: Int
) : Serializable