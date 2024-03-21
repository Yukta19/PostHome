package com.example.post

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/api/v1/products/")
    suspend fun postProduct(@Body productRequest: Category): Response<ProductResponse>
}