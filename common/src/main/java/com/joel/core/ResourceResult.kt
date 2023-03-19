package com.joel.core

sealed class ResourceResult<T>(val data : T ? = null, val error : String ?= null){
    class Success<T>(data: T) : ResourceResult<T>(data)
    class Loading<T>(data: T? = null) : ResourceResult<T>(data)
    class Error<T>(error: String, data: T? = null) : ResourceResult<T>(data, error)
}
