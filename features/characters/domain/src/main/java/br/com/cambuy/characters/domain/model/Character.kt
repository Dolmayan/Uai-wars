package br.com.cambuy.characters.domain.model

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail?,
)