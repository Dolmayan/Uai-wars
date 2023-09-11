package br.com.cambuy.uai.network.util

import com.google.gson.Gson
import retrofit2.Response

inline fun <T, reified U> Response<T>.convertErrorToObject(classType: Class<U>): U? =
    runCatching {
        this.errorBody()?.let {
            Gson().fromJson(it.string(), classType)
        }
    }.getOrNull()