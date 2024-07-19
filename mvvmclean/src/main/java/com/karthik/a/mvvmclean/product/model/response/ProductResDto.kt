package com.karthik.a.mvvmclean.product.model.response

import com.karthik.a.mvvmclean.product.model.response.Data

data class ProductResDto(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
)