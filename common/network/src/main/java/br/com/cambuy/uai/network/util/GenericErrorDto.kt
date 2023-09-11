package br.com.cambuy.uai.network.util

import com.google.gson.annotations.SerializedName

data class GenericErrorDto(
    @SerializedName("code")
    val code: Int,
    @SerializedName("description")
    val description: String,
)