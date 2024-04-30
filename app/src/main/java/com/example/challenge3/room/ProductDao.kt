package com.example.challenge3.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.challenge3.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAll(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getById(id: Int): Flow<Product>

    @Insert
    suspend fun insertProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}