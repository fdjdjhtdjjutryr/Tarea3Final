package com.example.tarea3final.data.remote.Services


import com.example.tarea3final.data.Categoria
import com.example.tarea3final.data.Contenido
import retrofit2.http.*
import retrofit2.Response



interface ApiService {
    @GET("categorias")
    suspend fun getCategorias(): List<Categoria>

    @POST("categorias")
    suspend fun createCategoria(@Body categoria: Categoria): Categoria

    @PUT("categorias/{id}")
    suspend fun updateCategoria(@Path("id") id: Int, @Body categoria: Categoria): Categoria

    @DELETE("categorias/{id}")
    suspend fun deleteCategoria(@Path("id") id: Int): Response<Unit>
}
