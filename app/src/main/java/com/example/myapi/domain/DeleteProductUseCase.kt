package com.example.myapi.domain

import com.example.myapi.data.Repository

class DeleteProductUseCase(val repository: Repository= Repository()) {
    suspend fun deleteProduct(productId:Int):Any{
        return repository.deleteProduct(productId)
    }
}