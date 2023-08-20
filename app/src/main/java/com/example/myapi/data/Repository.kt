package com.example.myapi.data

import com.example.myapi.data.model.LoginRequest
import com.example.myapi.data.model.LoginResponse
import com.example.myapi.data.model.ProductRequest
import com.example.myapi.data.model.products.ProductModel
import com.example.myapi.data.model.users.UserModel
import com.example.myapi.data.network.NetworkServices
import com.example.myapi.data.presestance.sharedpref.AppSharedPref
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository() {
    val sharedPref = AppSharedPref()
    var retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val network = retrofit.create(NetworkServices::class.java)


    suspend fun getUsers(): UserModel {
        return network.getUserList()
    }

    suspend fun addNewProduct(productRequest: ProductRequest): Any {
        return network.addNewProduct(productRequest)
    }

    suspend fun updateProduct(productRequest: ProductRequest, productId: Int): Any {
        return network.updateProduct(productRequest, productId)
    }

    suspend fun deleteProduct(productId: Int): Any {
        return network.deleteProduct(productId)
    }

    suspend fun searchForProduct(searchQuery: String): ProductModel {
        return network.searchForProductList(searchQuery)
    }

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return network.login(loginRequest)
    }

    suspend fun getAuthProduct(apiKey: String): ProductModel {
        return network.getProductList(apiKey)
    }

    fun saveToken(token: String) {
        sharedPref.saveToken(token)
    }

    fun getToken(): String? {
        return sharedPref.getToken()
    }

}