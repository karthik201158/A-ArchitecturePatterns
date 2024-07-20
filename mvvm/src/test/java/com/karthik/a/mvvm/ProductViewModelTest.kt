package com.karthik.a.mvvm

import com.karthik.a.mvvm.product.ProductViewModel
import com.karthik.a.mvvm.product.repository.ProductRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductViewModelTest {

    private lateinit var viewModel: ProductViewModel
    private lateinit var productRepository: ProductRepository

    @Before
    fun setUp() {
        // Use the mock repository in place of the actual repository
        productRepository = MockProductRepository()
        viewModel = ProductViewModel(productRepository)
    }
}
