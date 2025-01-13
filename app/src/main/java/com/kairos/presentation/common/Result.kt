package com.kairos.presentation.common


import com.kairos.data.remote.ApiError

sealed class Result<T : Any>() {
    class Loading<T : Any> : Result<T>()
    data class Success<T : Any>(val data: T) : Result<T>()
    data class Error<T : Any>(val error: ApiError) : Result<T>()
}