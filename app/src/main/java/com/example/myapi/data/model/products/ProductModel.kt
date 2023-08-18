package com.example.myapi.data.model.products

data class ProductModel(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)