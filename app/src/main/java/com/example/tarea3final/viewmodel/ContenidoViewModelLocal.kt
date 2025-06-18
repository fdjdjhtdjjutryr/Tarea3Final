//package com.example.tarea3final.viewmodel
//
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
////import com.example.tarea3final.data.Contenido
//import com.example.tarea3final.data.ContenidoRepository
//import com.example.tarea3final.data.remote.Services.Contenido
//import kotlinx.coroutines.launch
//
//class ContenidoViewModelLocal(private val contenidoRepository: ContenidoRepository) : ViewModel() {
//
//    var contenidoUiState by mutableStateOf(ContenidoUiState())
//        private set
//
//    fun updateUiState(nuevoContenido: ContenidoData) {
//        contenidoUiState = ContenidoUiState(
//            contenidoData = nuevoContenido,
//            isEntryValid = validateInput(nuevoContenido)
//        )
//    }
//
//    fun saveContenido(categoriaId: Int) {
//        if (validateInput()) {
//            viewModelScope.launch {
//                val contenido = contenidoUiState.contenidoData.copy(categoriaId = categoriaId).toContenido()
//                contenidoRepository.insertContenido(contenido)
//            }
//        }
//    }
//    fun deleteContenido(contenido: Contenido) {
//        viewModelScope.launch {
//            contenidoRepository.deleteContenido(contenido)
//        }
//    }
//    fun getContenidosPorCategoria(categoriaId: Int) =
//        contenidoRepository.getAllContenidoStreamByCategoria(categoriaId)
//
//    fun cargarContenidosIniciales() {
//        viewModelScope.launch {
//            contenidoRepository.getAllContenidoStreamByCategoria(1).collect { lista ->
//                if (lista.isEmpty()) {
//                    val contenidosIniciales = listOf(
//                        Contenido(
//                            titulo = "Macucha",
//                            tipo = "Película",
//                            descripcion = "Pelicula default chilena de dictadura , quien lo hubiera imaginado...",
//                            imagen = "pelicula1",
//                            categoriaId = 1
//                        ),
//                        Contenido(
//                            titulo = "Malena",
//                            tipo = "Pelicula",
//                            descripcion = "Monica Bellucci.",
//                            imagen = "monicabellucci",
//                            categoriaId = 1
//                        ),
//                        Contenido(
//                            titulo = "Titanes del pacifico",
//                            tipo = "Pelicula",
//                            descripcion = "Pelicula de mechas , solo hay una , tristemente no tiene secuela",
//                            imagen = "pacificrim",
//                            categoriaId = 1
//                        ),
//                        Contenido(
//                            titulo = "Rapidos y furiosos",
//                            tipo = "Serie",
//                            descripcion = "No sabia que ibamos a caer aca , solo TUVE fe QUE QUEEEE??",
//                            imagen = "rapidosyfuriosos",
//                            categoriaId = 1
//                        ),
//                        Contenido(
//                            titulo = "Breaking Bad",
//                            tipo = "Serie",
//                            descripcion = "Un profesor de química se convierte en fabricante de metanfetamina.",
//                            imagen = "brbad",
//                            categoriaId = 2
//                        ),
//                        Contenido(
//                            titulo = "Vikingos",
//                            tipo = "Pelicula",
//                            descripcion = "RAAAAHH",
//                            imagen = "vikings",
//                            categoriaId = 2
//                        ),
//                        Contenido(
//                            titulo = "Game of Thrones",
//                            tipo = "Serie",
//                            descripcion = "Luchas de poder en los 7 reinos",
//                            imagen = "got",
//                            categoriaId = 2
//                        ),
//                        Contenido(
//                            titulo = "HunterXHunter",
//                            tipo = "Anime",
//                            descripcion = "Gon y la banda",
//                            imagen = "hxh",
//                            categoriaId = 3
//                        )
//                    )
//                    contenidosIniciales.forEach {
//                        contenidoRepository.insertContenido(it)
//                    }
//                }
//            }
//        }
//    }
//
//
//
//    private fun validateInput(contenido: ContenidoData = contenidoUiState.contenidoData): Boolean {
//        return contenido.titulo.isNotBlank() &&
//                contenido.descripcion.isNotBlank() &&
//                contenido.tipo.isNotBlank()
//    }
//}
//
//data class ContenidoUiState(
//    val contenidoData: ContenidoData = ContenidoData(),
//    val isEntryValid: Boolean = false
//)
//
//data class ContenidoData(
//    val id: Int = 0,
//    val titulo: String = "",
//    val tipo: String = "",
//    val descripcion: String = "",
//    val imagen: String = "",
//    val categoriaId: Int = 0
//)
//
//fun ContenidoData.toContenido(): Contenido = Contenido(
//    id = id,
//    titulo = titulo,
//    tipo = tipo,
//    descripcion = descripcion,
//    imagen = imagen,
//    categoriaId = categoriaId
//)
//
//fun Contenido.toUiState(isEntryValid: Boolean = false): ContenidoUiState = ContenidoUiState(
//    contenidoData = ContenidoData(id, titulo, tipo, descripcion, imagen, categoriaId),
//    isEntryValid = isEntryValid
//)

