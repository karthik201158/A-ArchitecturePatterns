package com.karthik.a.mvvm.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karthik.a.mvvm.product.model.response.ProductResDto
import com.karthik.a.mvvm.product.repository.ProductRepository
import com.karthik.a.mvvm.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    private val _productList = MutableStateFlow<NetworkResult<ProductResDto>>(NetworkResult.Loading())
    val productList: StateFlow<NetworkResult<ProductResDto>> = _productList

    fun getProducts(){
        viewModelScope.launch {
            _productList.value = NetworkResult.Loading()
            val result =   productRepository.getProducts()
            _productList.value = result
        }
    }

}