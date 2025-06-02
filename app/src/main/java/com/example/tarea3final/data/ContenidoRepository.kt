package com.example.tarea3final.data

import kotlinx.coroutines.flow.Flow

interface ContenidoRepository {
    fun getAllContenidoStreamByCategoria(categoriaId: Int): Flow<List<Contenido>>
    fun getContenidoStream(id: Int): Flow<Contenido?>
    suspend fun insertContenido(contenido: Contenido)
    suspend fun deleteContenido(contenido: Contenido)
    suspend fun updateContenido(contenido: Contenido)
}