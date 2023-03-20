package br.com.cambuy.uai.preference

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferenceModel(
    val favoriteCharacter: FavoriteCharacter? = null,
)

@Serializable
data class FavoriteCharacter(
    val id: Int,
    val name: String,
)