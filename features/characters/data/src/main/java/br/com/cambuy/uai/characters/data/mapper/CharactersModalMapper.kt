package br.com.cambuy.uai.characters.data.mapper

import br.com.cambuy.characters.domain.model.Character
import br.com.cambuy.characters.domain.model.ListCharacter
import br.com.cambuy.characters.domain.model.Thumbnail
import br.com.cambuy.uai.network.dto.CharacterDto
import br.com.cambuy.uai.network.dto.CharacterResponseDto
import br.com.cambuy.uai.network.dto.ThumbnailDto

fun CharacterResponseDto.toDomain(): ListCharacter {
    return ListCharacter(
        results = this.data?.results?.map { it.toDomain() } ?: emptyList()
    )
}

fun CharacterDto.toDomain(): Character {
    return Character(
        id = id ?: 0,
        name = name.orEmpty(),
        description = description.orEmpty(),
        thumbnail = thumbnailDto?.toDomain()
    )
}

fun ThumbnailDto.toDomain(): Thumbnail {
    return Thumbnail(
        path = path.orEmpty(),
        extension = extension.orEmpty()
    )
}