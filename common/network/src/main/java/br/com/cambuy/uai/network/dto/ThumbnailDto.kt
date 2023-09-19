package br.com.cambuy.uai.network.dto

import com.google.gson.annotations.SerializedName

data class ThumbnailDto(
    @SerializedName("path")
    val path: String? = null,
    @SerializedName("extension")
    val extension: String? = null,
)