package br.com.cambuy.characters.domain.model

data class PeopleResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Character>
)