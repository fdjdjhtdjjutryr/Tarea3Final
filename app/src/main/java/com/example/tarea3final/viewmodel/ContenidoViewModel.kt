package com.example.tarea3final.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea3final.data.ContenidoRepositoryApi
import com.example.tarea3final.data.Contenido
import com.example.tarea3final.data.remote.Services.ContenidoService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContenidoViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = ContenidoRepositoryApi(app)

    private val _contenidos = MutableStateFlow<List<Contenido>>(emptyList())
    val contenidos: StateFlow<List<Contenido>> = _contenidos

    fun cargarContenidos() {
        viewModelScope.launch {
            _contenidos.value = repo.getContenidos()
        }
    }

    fun agregarContenido(contenido: Contenido) {
        viewModelScope.launch {
            repo.createContenido(contenido)
            cargarContenidos()
        }
    }

    fun editarContenido(id: Int, contenido: Contenido) {
        viewModelScope.launch {
            repo.updateContenido(id, contenido)
            cargarContenidos()
        }
    }

    fun eliminarContenido(id: Int) {
        viewModelScope.launch {
            repo.deleteContenido(id)
            cargarContenidos()
        }
    }
}