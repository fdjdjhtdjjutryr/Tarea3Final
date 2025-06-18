package com.example.tarea3final.data

data class Categoria(
    val id: Int? = null,
    val nombre: String,
    val descripcion: String
)


//
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
//@Entity(tableName = "categorias")
//data class Categoria(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,
//    val nombre: String,
//    val descripcion: String
//)
