package com.example.tarea3final.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contenido")
data class Contenido(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val tipo: String,
    val descripcion: String,
    val imagen: String = " ",
    val categoriaId: Int
)
