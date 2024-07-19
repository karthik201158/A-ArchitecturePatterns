package com.karthik.a.mvvm.product.model.response

data class ProductResDto(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
)