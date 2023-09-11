package br.com.cambuy.uai.characters.data.mapper

import br.com.cambuy.characters.domain.model.Character
import br.com.cambuy.characters.domain.model.PeopleResponse
import br.com.cambuy.uai.characters.data.dto.CharacterDto
import br.com.cambuy.uai.characters.data.dto.PeopleResponseDto

fun PeopleResponseDto.toDomain(): PeopleResponse {
    return PeopleResponse(
        count = count ?: 0,
        next = next.orEmpty(),
        previous = previous ?: Any(),
        results = results?.map { it.toDomain() } ?: emptyList()
    )
}

fun CharacterDto.toDomain(): Character {
    return Character(
        birthYear = birthYear.orEmpty(),
        eyeColor = eyeColor.orEmpty(),
        films = films ?: emptyList(),
        gender = gender.orEmpty(),
        hairColor = hairColor.orEmpty(),
        height = height.orEmpty(),
        homeWorld = homeWorld.orEmpty(),
        mass = mass.orEmpty(),
        name = name.orEmpty(),
        skinColor = skinColor.orEmpty()
    )
}