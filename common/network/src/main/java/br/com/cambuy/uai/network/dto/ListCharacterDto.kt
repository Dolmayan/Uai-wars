package br.com.cambuy.uai.network.dto

import com.google.gson.annotations.SerializedName

data class ListCharacterDto(
    @SerializedName("results")
    val results: List<CharacterDto>? = null,
)