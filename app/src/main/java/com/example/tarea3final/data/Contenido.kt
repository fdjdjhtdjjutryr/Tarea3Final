package com.example.tarea3final.data

data class Contenido(
    val id: Int? = null,
    val titulo: String,
    val tipo: String,
    val descripcion: String,
    val imagen: String,
    val categoria_id: Int
)




//
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
//@Entity(tableName = "contenido")
//data class Contenido(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,
//    val titulo: String,
//    val tipo: String,
//    val descripcion: String,
//    val imagen: String = " ",
//    val categoriaId: Int
//)
