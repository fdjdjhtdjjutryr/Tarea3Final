package com.example.tarea3final.data

import android.content.Context
import com.example.tarea3final.data.remote.ApiClient
import com.example.tarea3final.data.Categoria
import com.example.tarea3final.data.remote.Services.ApiService
import com.example.tarea3final.data.remote.Services.ContenidoService

class CategoriaRepositoryApi(context: Context) {
    private val retrofit = ApiClient.create(context)
    private val api = retrofit.create(ApiService::class.java)

    suspend fun getCategorias(): List<Categoria> = api.getCategorias()
    suspend fun createCategoria(categoria: Categoria): Categoria = api.createCategoria(categoria)
    suspend fun deleteCategoria(categoria: Categoria) = categoria.id?.let { api.deleteCategoria(it) }
}