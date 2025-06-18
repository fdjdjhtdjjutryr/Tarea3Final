//package com.example.tarea3final.viewmodel
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.tarea3final.Tarea3
//
//class ViewModelProvider(private val application: Application) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        val container = (application as Tarea3).container
//        return when {
//            modelClass.isAssignableFrom(CategoriaViewModel::class.java) -> {
//                CategoriaViewModel(container.categoriaRepository) as T
//            }
//            modelClass.isAssignableFrom(ContenidoViewModel::class.java) -> {
//                ContenidoViewModel(container.contenidoRepository) as T
//            }
//            else -> throw IllegalArgumentException("Unknown ViewModel class")
//        }
//    }
//}