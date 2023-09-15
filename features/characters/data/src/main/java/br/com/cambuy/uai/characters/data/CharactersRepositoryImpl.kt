package br.com.cambuy.uai.characters.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.cambuy.characters.domain.CharactersRepository
import br.com.cambuy.characters.domain.model.Character
import br.com.cambuy.uai.characters.data.mapper.toDomain
import br.com.cambuy.uai.characters.data.paging.CharactersPagingSource
import br.com.cambuy.uai.network.service.CharactersService
import br.com.cambuy.uai.core.util.Resource
import br.com.cambuy.uai.core.util.ResourceError
import br.com.cambuy.uai.network.util.GenericErrorDto
import br.com.cambuy.uai.network.util.convertErrorToObject
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class CharactersRepositoryImpl @Inject constructor(
    private val service: CharactersService
) : CharactersRepository {

    override suspend fun getCharactersList(textSearch: String): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharactersPagingSource(service, textSearch)
            }
        ).flow
    }

    override suspend fun getCharactersById(id: Int): Resource<Character> {
        return runCatching {
            val result = service.getCharactersById(id)
            if (result.isSuccessful) {
                result.body()?.let {
                    return Resource.Success(data = it.toDomain())
                }
            }
            val error = result.convertErrorToObject(GenericErrorDto::class.java)
            error?.let { return handleError(it) }
            Resource.Error<Character>(ResourceError.CharactersError())
        }.getOrElse {
            Resource.Error(ResourceError.CharactersError(description = it.message))
        }
    }

    private fun <T> handleError(error: GenericErrorDto): Resource<T> {
        return Resource.Error(
            ResourceError.CharactersError(
                errorCode = error.code,
                description = error.description
            )
        )
    }

    private companion object {
        const val PAGE_SIZE = 30
    }
}