package com.example.tarea3final.data

import kotlinx.coroutines.flow.Flow

class LocalContenidoRepository(private val contenidoDao: ContenidoDao) : ContenidoRepository {
    override fun getAllContenidoStreamByCategoria(categoriaId: Int): Flow<List<Contenido>> =
        contenidoDao.getByCategoria(categoriaId)

    override fun getContenidoStream(id: Int): Flow<Contenido?> = contenidoDao.getById(id)

    override suspend fun insertContenido(contenido: Contenido) = contenidoDao.insert(contenido)

    override suspend fun deleteContenido(contenido: Contenido) = contenidoDao.delete(contenido)

    override suspend fun updateContenido(contenido: Contenido) = contenidoDao.update(contenido)
}