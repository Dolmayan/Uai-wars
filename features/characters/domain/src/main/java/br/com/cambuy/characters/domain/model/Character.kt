package br.com.cambuy.characters.domain.model

data class Character(
    val birthYear: String,
    val eyeColor: String,
    val films: List<String>,
    val gender: String,
    val hairColor: String,
    val height: String,
    val homeWorld: String,
    val mass: String,
    val name: String,
    val skinColor: String
)