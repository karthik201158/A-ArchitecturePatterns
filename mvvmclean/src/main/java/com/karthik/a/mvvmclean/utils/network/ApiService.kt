package com.karthik.a.mvvmclean.utils.network

import com.karthik.a.mvvmclean.product.model.response.ProductResDto

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("product")
    suspend fun getProducts(): Response<ProductResDto>
}