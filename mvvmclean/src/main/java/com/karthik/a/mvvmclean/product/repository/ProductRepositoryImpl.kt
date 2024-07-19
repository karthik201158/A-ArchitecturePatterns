package com.karthik.a.mvvmclean.product.repository

import com.karthik.a.mvvmclean.product.model.response.ProductResDto
import com.karthik.a.mvvmclean.utils.BaseApiResponse
import com.karthik.a.mvvmclean.utils.NetworkResult
import com.karthik.a.mvvmclean.utils.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository, BaseApiResponse() {

    override suspend fun getProducts() : NetworkResult<ProductResDto> {
       return handleApiCall {
           apiService.getProducts()
       }
    }

    override suspend fun getProductsByCreatingFlow(): Flow<NetworkResult<ProductResDto>> {
        return flow{
            emit(
                handleApiCall {
                    apiService.getProducts()
                }
            )
        }.flowOn(Dispatchers.IO)
    }
}