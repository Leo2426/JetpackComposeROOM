package com.example.challenge3.states

import com.example.challenge3.model.Product

data class ProductState (
    val products: List<Product> = emptyList()
)