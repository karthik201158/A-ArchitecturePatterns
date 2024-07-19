package com.karthik.a.mvvm.utils.network

import com.karthik.a.mvvm.product.model.response.ProductResDto

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("product")
    suspend fun getProducts(): Response<ProductResDto>
}