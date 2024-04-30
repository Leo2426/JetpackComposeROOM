package com.example.challenge3.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.challenge3.model.Product

@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = false
)

abstract class ProductsDataBase: RoomDatabase(){
    abstract fun productDao(): ProductDao
}