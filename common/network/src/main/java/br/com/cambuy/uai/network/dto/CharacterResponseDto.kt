package br.com.cambuy.uai.network.dto

import com.google.gson.annotations.SerializedName

data class CharacterResponseDto(
    @SerializedName("data")
    val data: ListCharacterDto ? = null,
)