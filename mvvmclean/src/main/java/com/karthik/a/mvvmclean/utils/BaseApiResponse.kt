package com.karthik.a.mvvmclean.utils

import retrofit2.Response

abstract class BaseApiResponse {

    suspend fun <T> handleApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try{
            val response = apiCall()
            if(response.isSuccessful){
                val body = response.body()
                body?.let {
                 return NetworkResult.Success(body)
                }
            }
            return error(response.errorBody().toString())
        }catch (e: Exception) {
            return error(e.message?:e.toString())
        }
    }

    private fun <T> error(error:String): NetworkResult<T> =
        NetworkResult.Error(error)
}