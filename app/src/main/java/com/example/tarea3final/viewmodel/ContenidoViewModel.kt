package com.example.tarea3final.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea3final.data.Contenido
import com.example.tarea3final.data.ContenidoRepository
import kotlinx.coroutines.launch

class ContenidoViewModel(private val contenidoRepository: ContenidoRepository) : ViewModel() {

    var contenidoUiState by mutableStateOf(ContenidoUiState())
        private set

    fun updateUiState(nuevoContenido: ContenidoData) {
        contenidoUiState = ContenidoUiState(
            contenidoData = nuevoContenido,
            isEntryValid = validateInput(nuevoContenido)
        )
    }

    fun saveContenido(categoriaId: Int) {
        if (validateInput()) {
            viewModelScope.launch {
                val contenido = contenidoUiState.contenidoData.copy(categoriaId = categoriaId).toContenido()
                contenidoRepository.insertContenido(contenido)
            }
        }
    }
    fun getContenidosPorCategoria(categoriaId: Int) =
        contenidoRepository.getAllContenidoStreamByCategoria(categoriaId)



    private fun validateInput(contenido: ContenidoData = contenidoUiState.contenidoData): Boolean {
        return contenido.titulo.isNotBlank() &&
                contenido.descripcion.isNotBlank() &&
                contenido.tipo.isNotBlank()
    }
}

data class ContenidoUiState(
    val contenidoData: ContenidoData = ContenidoData(),
    val isEntryValid: Boolean = false
)

data class ContenidoData(
    val id: Int = 0,
    val titulo: String = "",
    val tipo: String = "",
    val descripcion: String = "",
    val imagen: String = "",
    val categoriaId: Int = 0
)

fun ContenidoData.toContenido(): Contenido = Contenido(
    id = id,
    titulo = titulo,
    tipo = tipo,
    descripcion = descripcion,
    imagen = imagen,
    categoriaId = categoriaId
)

fun Contenido.toUiState(isEntryValid: Boolean = false): ContenidoUiState = ContenidoUiState(
    contenidoData = ContenidoData(id, titulo, tipo, descripcion, imagen, categoriaId),
    isEntryValid = isEntryValid
)