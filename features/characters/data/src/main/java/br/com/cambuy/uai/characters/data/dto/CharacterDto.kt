package br.com.cambuy.uai.characters.data.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("birth_year")
    val birthYear: String? = null,
    @SerializedName("eye_color")
    val eyeColor: String? = null,
    @SerializedName("films")
    val films: List<String>? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("hair_color")
    val hairColor: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("homeworld")
    val homeWorld: String? = null,
    @SerializedName("mass")
    val mass: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("skin_color")
    val skinColor: String? = null
)