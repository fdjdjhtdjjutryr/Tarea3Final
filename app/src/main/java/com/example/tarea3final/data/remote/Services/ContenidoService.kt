package com.example.tarea3final.data.remote.Services

import retrofit2.http.*
import retrofit2.Response
import com.example.tarea3final.data.Contenido


interface ContenidoService {
    @GET("contenidos")
    suspend fun getContenidos(): List<Contenido>

    @POST("contenidos")
    suspend fun createContenido(@Body contenido: Contenido): Contenido

    @PUT("contenidos/{id}")
    suspend fun updateContenido(@Path("id") id: Int, @Body contenido: Contenido): Contenido

    @DELETE("contenidos/{id}")
    suspend fun deleteContenido(@Path("id") id: Int): Response<Unit>
}