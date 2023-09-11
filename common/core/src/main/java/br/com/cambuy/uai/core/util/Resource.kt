package br.com.cambuy.uai.core.util

sealed class Resource<T>(val data: T? = null, val error: ResourceError<T>? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(error: ResourceError<T>, data: T? = null) : Resource<T>(data, error)
}