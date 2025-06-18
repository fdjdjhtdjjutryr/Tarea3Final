//package com.example.tarea3final.data
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import kotlinx.coroutines.flow.Flow
//import androidx.room.Update
//
//@Dao
//interface ContenidoDao {
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(contenido: Contenido)
//
//    @Update
//    suspend fun update(contenido: Contenido)
//
//    @Delete
//    suspend fun delete(contenido: Contenido)
//
//    @Query("SELECT * FROM contenido WHERE id = :id")
//    fun getById(id: Int): Flow<Contenido>
//
//    @Query("SELECT * FROM contenido WHERE categoriaId = :categoriaId ORDER BY titulo ASC")
//    fun getByCategoria(categoriaId: Int): Flow<List<Contenido>>
//
//    @Query("SELECT * FROM contenido ORDER BY titulo ASC")
//    fun getAll(): Flow<List<Contenido>>
//}