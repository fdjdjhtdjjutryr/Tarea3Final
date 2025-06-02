package com.example.tarea3final.data

import kotlinx.coroutines.flow.Flow

class LocalCategoriaRepository(private val categoriaDao: CategoriaDao) : CategoriaRepository {
    override fun getAllCategoriaStream(): Flow<List<Categoria>> = categoriaDao.getAllItems()

    override fun getCategoriaStream(id: Int): Flow<Categoria?> = categoriaDao.getItem(id)

    override suspend fun insertCategoria(categoria: Categoria) = categoriaDao.insert(categoria)

    override suspend fun deleteCategoria(categoria: Categoria) = categoriaDao.delete(categoria)

    override suspend fun updateCategoria(categoria: Categoria) = categoriaDao.update(categoria)
}