package br.com.cambuy.uai.network.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("thumbnail")
    val thumbnailDto: ThumbnailDto? = null,
)