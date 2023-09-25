package br.com.cambuy.uai.network.dto.comics

import com.google.gson.annotations.SerializedName

data class ComicsResponseDto(
    @SerializedName("data")
    val data: ListComicDto? = null,
)