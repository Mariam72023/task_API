package com.example.myapi.domain

import com.example.myapi.data.Repository
import com.example.myapi.data.model.products.ProductModel
import com.example.myapi.domain.model.CustomUiModel

class GetProductUseCase(val repository: Repository= Repository()) {
    suspend fun getAuthProduct(apiKey: String): List<CustomUiModel> {
        return repository.getAuthProduct(apiKey).products.map {
            CustomUiModel(
                headlineText = it.title,
                supportingText = it.description
            )
        }
    }

}