package com.karthik.a.mvvm.product.repository

import com.karthik.a.mvvm.product.model.response.ProductResDto
import com.karthik.a.mvvm.utils.BaseApiResponse
import com.karthik.a.mvvm.utils.NetworkResult
import com.karthik.a.mvvm.utils.network.ApiService
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository, BaseApiResponse() {

    override suspend fun getProducts() :NetworkResult<ProductResDto> {
       return handleApiCall {
           apiService.getProducts()
       }
    }
}