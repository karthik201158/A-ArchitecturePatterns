package com.karthik.a.mvvm

import com.karthik.a.mvvm.product.model.response.Data
import com.karthik.a.mvvm.product.model.response.ProductResDto
import com.karthik.a.mvvm.product.repository.ProductRepository
import com.karthik.a.mvvm.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

class MockProductRepository : ProductRepository {
    override suspend fun getProducts(): NetworkResult<ProductResDto> {
        val mockProduct = ProductResDto(
            data = listOf(
                Data(
                    categoryId = 1,
                    description = "Mock Description",
                    price = 10.0,
                    productId = 1,
                    productName = "Mock Product",
                    quantity = 5
                )
            ),
            message = "Success",
            status = 200,
            success = true
        )
        return NetworkResult.Success(mockProduct)
    }

    override suspend fun getProductsByCreatingFlow(): Flow<NetworkResult<ProductResDto>> {
        TODO("Not yet implemented")
    }
}
