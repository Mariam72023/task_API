package com.example.myapi.data.network

import com.example.myapi.data.model.LoginRequest
import com.example.myapi.data.model.LoginResponse

import com.example.myapi.data.model.ProductRequest
import com.example.myapi.data.model.products.ProductModel
import com.example.myapi.data.model.users.User
import com.example.myapi.data.model.users.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

public interface NetworkServices {
    @GET("auth/products")
    suspend fun getProductList(@Header("Authorization")apiKey:String): ProductModel

    @GET("users")
    suspend fun getUserList(): UserModel

    @POST("products/add")
    suspend fun addNewProduct(@Body productRequest: ProductRequest): Any

    @PUT("products/{id}")
    suspend fun updateProduct(@Body productRequest: ProductRequest, @Path("id") productId: Int): Any

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") productId: Int): Any

    @GET("products/search")
    suspend fun searchForProductList(@Query("q") searchQuery:String): ProductModel


    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest):LoginResponse


}