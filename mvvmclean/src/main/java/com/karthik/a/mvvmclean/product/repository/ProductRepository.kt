package com.karthik.a.mvvmclean.product.repository

import com.karthik.a.mvvmclean.product.model.response.ProductResDto
import com.karthik.a.mvvmclean.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts() : NetworkResult<ProductResDto>
    suspend fun getProductsByCreatingFlow() : Flow<NetworkResult<ProductResDto>>
}