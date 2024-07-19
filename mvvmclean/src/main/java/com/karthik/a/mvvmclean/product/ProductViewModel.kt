package com.karthik.a.mvvmclean.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karthik.a.mvvmclean.product.model.response.ProductResDto
import com.karthik.a.mvvmclean.product.repository.ProductRepository
import com.karthik.a.mvvmclean.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    private val _productList = MutableStateFlow<NetworkResult<ProductResDto>>(NetworkResult.Loading())
    val productList: StateFlow<NetworkResult<ProductResDto>> = _productList

    fun getProducts(){
        viewModelScope.launch() {
            _productList.value = NetworkResult.Loading()
            val result = withContext(Dispatchers.IO) {
                productRepository.getProducts()
            }
            _productList.value = result
        }
    }

    fun getProductsWithFlow(){
        viewModelScope.launch() {
            _productList.value = NetworkResult.Loading()
            productRepository.getProductsByCreatingFlow()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _productList.value = NetworkResult.Error(e.toString())
                }
                .collect{
                    _productList.value = it
                }
        }
    }

}