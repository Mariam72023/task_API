package com.example.myapi.domain

import com.example.myapi.data.Repository
import com.example.myapi.data.model.ProductRequest

class AddNewProductUseCase(val repository: Repository= Repository()) {
   suspend fun addNewProduct(productRequest: ProductRequest):Any
   {
       return repository.addNewProduct(productRequest)
   }
}