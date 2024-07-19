package com.karthik.a.mvvm.product.repository

import com.karthik.a.mvvm.product.model.response.ProductResDto
import com.karthik.a.mvvm.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts() : NetworkResult<ProductResDto>

    suspend fun getProductsByCreatingFlow() : Flow<NetworkResult<ProductResDto>>
}