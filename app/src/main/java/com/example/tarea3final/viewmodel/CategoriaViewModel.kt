package com.example.tarea3final.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.tarea3final.data.CategoriaRepository
import com.example.tarea3final.data.CategoriaRepositoryApi
import com.example.tarea3final.data.Categoria
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

class CategoriaViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = CategoriaRepositoryApi(app)

    private val _categorias = MutableStateFlow<List<Categoria>>(emptyList())
    val categorias: StateFlow<List<Categoria>> = _categorias

    var categoriaUiState by mutableStateOf(CategoriaUiState())
        private set

    init {
        viewModelScope.launch {
            _categorias.value = repo.getCategorias()
        }
    }

    fun updateUiState(nuevaCategoria: CategoriaData) {
        categoriaUiState = CategoriaUiState(
            categoriaData = nuevaCategoria,
            isEntryValid = validateInput(nuevaCategoria)
        )
    }

    fun saveCategoria() {
        if (validateInput()) {
            viewModelScope.launch {
                val categoria = categoriaUiState.categoriaData.toCategoria()
                repo.createCategoria(categoria)
                _categorias.value = repo.getCategorias()
            }
        }
    }

    fun deleteCategoria(categoria: Categoria) {
        viewModelScope.launch {
            repo.deleteCategoria(categoria)
            _categorias.value = repo.getCategorias()
        }
    }

    private fun validateInput(categoria: CategoriaData = categoriaUiState.categoriaData): Boolean {
        return categoria.nombre.isNotBlank() && categoria.descripcion.isNotBlank()
    }
}



data class CategoriaUiState(
    val categoriaData: CategoriaData = CategoriaData(),
    val isEntryValid: Boolean = false
)

data class CategoriaData(
    val id: Int = 0,
    val nombre: String = "",
    val descripcion: String = ""
)

fun CategoriaData.toCategoria(): Categoria = Categoria(
    id = id,
    nombre = nombre,
    descripcion = descripcion
)

fun Categoria.toUiState(isEntryValid: Boolean = false): CategoriaUiState = CategoriaUiState(
    categoriaData = CategoriaData(id ?: 0, nombre, descripcion),
    isEntryValid = isEntryValid
)
