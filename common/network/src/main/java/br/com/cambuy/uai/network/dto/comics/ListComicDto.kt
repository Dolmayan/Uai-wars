package br.com.cambuy.uai.network.dto.comics

import com.google.gson.annotations.SerializedName

data class ListComicDto(
    @SerializedName("results")
    val results: List<ComicDto>? = null,
)