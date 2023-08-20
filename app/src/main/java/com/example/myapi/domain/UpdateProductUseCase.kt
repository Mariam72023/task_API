package com.example.myapi.domain

import com.example.myapi.data.Repository
import com.example.myapi.data.model.ProductRequest

class UpdateProductUseCase(val repository: Repository= Repository()) {
    suspend fun updateProduct(productRequest: ProductRequest,productId:Int):Any
    {
        return repository.updateProduct(productRequest,productId)
    }
}