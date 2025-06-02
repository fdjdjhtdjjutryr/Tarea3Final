package com.example.tarea3final.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tarea3final.Tarea3
import com.example.tarea3final.data.AppContainer

object AppViewModelProvider {
    lateinit var appContainer: AppContainer

    val Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when {
                modelClass.isAssignableFrom(CategoriaViewModel::class.java) -> {
                    CategoriaViewModel(appContainer.categoriaRepository) as T
                }
                modelClass.isAssignableFrom(ContenidoViewModel::class.java) -> {
                    ContenidoViewModel(appContainer.contenidoRepository) as T
                }
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        }
    }
}