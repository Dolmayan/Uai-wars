package br.com.cambuy.uai.network.dto

import com.google.gson.annotations.SerializedName

data class PeopleResponseDto(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: Any? = null,
    @SerializedName("results")
    val results: List<CharacterDto>? = null
)