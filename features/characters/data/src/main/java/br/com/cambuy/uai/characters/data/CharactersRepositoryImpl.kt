package br.com.cambuy.uai.characters.data

import br.com.cambuy.characters.domain.CharactersRepository
import br.com.cambuy.characters.domain.model.PeopleResponse
import br.com.cambuy.uai.characters.data.mapper.toDomain
import br.com.cambuy.uai.characters.data.service.CharactersService
import br.com.cambuy.uai.core.util.Resource
import br.com.cambuy.uai.core.util.ResourceError
import br.com.cambuy.uai.network.util.GenericErrorDto
import br.com.cambuy.uai.network.util.convertErrorToObject
import javax.inject.Inject

internal class CharactersRepositoryImpl @Inject constructor(
    private val service: CharactersService
) : CharactersRepository {

    override suspend fun getCharactersList(page: Int): Resource<PeopleResponse> =
        runCatching {
            val result = service.getCharacters(page)
            if (result.isSuccessful) {
                result.body()?.let {
                    return Resource.Success(data = it.toDomain())
                }
            }
            val error = result.convertErrorToObject(GenericErrorDto::class.java)
            error?.let { return handleError(it) }
            Resource.Error<PeopleResponse>(ResourceError.CharactersError())
        }.getOrElse {
            Resource.Error(ResourceError.CharactersError(description = it.message))
        }

    private fun <T> handleError(error: GenericErrorDto): Resource<T> {
        return Resource.Error(
            ResourceError.CharactersError(
                errorCode = error.code,
                description = error.description
            )
        )
    }
}