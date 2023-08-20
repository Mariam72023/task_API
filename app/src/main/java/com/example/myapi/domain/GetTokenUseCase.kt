package com.example.myapi.domain

import com.example.myapi.data.Repository

class GetTokenUseCase(val repository: Repository = Repository()) {
    fun getToken(): String? {
        return repository.getToken()
    }
}