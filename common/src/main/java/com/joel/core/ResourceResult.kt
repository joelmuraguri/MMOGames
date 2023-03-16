package com.joel.core

sealed class ResourceResult<T>(val data : T ? = null, val error : String ?= null){
    class Success<T>(data: T) : ResourceResult<T>(data)
    class Loading<T>(data: T?) : ResourceResult<T>(data)
    class Error<T>(error: String) : ResourceResult<T>(data = null, error)
}
