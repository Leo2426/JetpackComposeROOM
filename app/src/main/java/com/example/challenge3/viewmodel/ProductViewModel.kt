package com.example.challenge3.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge3.model.Product
import com.example.challenge3.room.ProductDao
import com.example.challenge3.states.ProductState
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class ProductViewModel(
    private val dao: ProductDao
):ViewModel() {

    var state by mutableStateOf(ProductState())
    private set

    init {
        viewModelScope.launch {
            dao.getAll().collectLatest {
                state = state.copy(products = it)
            }
        }
    }

    fun getAllProducts() = viewModelScope.launch {
        dao.getAll().collectLatest {
            state = state.copy(products = it)
        }
    }

    fun addProduct(product: Product) = viewModelScope.launch {
        dao.insertProduct(product = product)
    }

    fun updateProduct(product: Product) = viewModelScope.launch {
        dao.updateProduct(product = product)
    }

    fun deleteProduct(product: Product) = viewModelScope.launch {
        dao.deleteProduct(product = product)
    }

    fun getProductById(id: Int) = viewModelScope.launch {
        dao.getById(id).collect {
            state = state.copy(products = listOf(it))
        }
    }

}