package com.example.myapi.domain

import com.example.myapi.data.Repository
import com.example.myapi.data.model.products.ProductModel
import com.example.myapi.domain.model.CustomUiModel

class SearchProductUseCase(val repository: Repository= Repository()) {
    suspend fun searchForProduct(searchQuery:String): List<CustomUiModel> {
        return repository.searchForProduct(searchQuery).products.map {
            CustomUiModel(it.title,it.description)
        }
    }
}