package com.example.tarea3final.data

import android.content.Context
import com.example.tarea3final.data.remote.ApiClient
import com.example.tarea3final.data.Contenido
import com.example.tarea3final.data.remote.Services.ContenidoService

class ContenidoRepositoryApi(context: Context) {
    private val retrofit = ApiClient.create(context)
    private val api = retrofit.create(ContenidoService::class.java)

    suspend fun getContenidos(): List<Contenido> = api.getContenidos()
    suspend fun createContenido(contenido: Contenido): Contenido = api.createContenido(contenido)
    suspend fun updateContenido(id: Int, contenido: Contenido): Contenido = api.updateContenido(id, contenido)
    suspend fun deleteContenido(id: Int) = api.deleteContenido(id)
}



