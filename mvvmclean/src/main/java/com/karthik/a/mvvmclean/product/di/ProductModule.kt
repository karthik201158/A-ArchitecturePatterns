package com.karthik.a.mvvmclean.product.di

import com.karthik.a.mvvmclean.product.repository.ProductRepository
import com.karthik.a.mvvmclean.product.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductModule {

    @Binds
    abstract fun bindProductInterface(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}