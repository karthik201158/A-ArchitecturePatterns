package com.karthik.a.mvvm.product.repository

import com.karthik.a.mvvm.product.model.response.ProductResDto
import com.karthik.a.mvvm.utils.NetworkResult

interface ProductRepository {
    suspend fun getProducts() : NetworkResult<ProductResDto>
}