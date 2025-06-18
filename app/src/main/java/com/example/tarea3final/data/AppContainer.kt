//package com.example.tarea3final.data
//
//import android.content.Context
//
//interface AppContainer {
//    val categoriaRepository: CategoriaRepository
//    val contenidoRepository: ContenidoRepository
//}
//
//class AppDataContainer(private val context: Context) : AppContainer {
//    private val database by lazy { AppDatabase.getDatabase(context) }
//
//    override val categoriaRepository: CategoriaRepository by lazy {
//        LocalCategoriaRepository(database.categoriaDao())
//    }
//
//    override val contenidoRepository: ContenidoRepository by lazy {
//        LocalContenidoRepository(database.contenidoDao())
//    }
//}
