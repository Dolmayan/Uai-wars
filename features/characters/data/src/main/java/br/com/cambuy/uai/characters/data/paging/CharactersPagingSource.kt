package br.com.cambuy.uai.characters.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.cambuy.characters.domain.model.Character
import br.com.cambuy.uai.characters.data.mapper.toDomain
import br.com.cambuy.uai.network.service.CharactersService

class CharactersPagingSource(
    private val service: CharactersService,
    private val textSearch: String
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val position = params.key ?: FIRST_PAGE_INDEX
        return try {
            val response = service.getCharacters(position, textSearch)

            if (response.isSuccessful) {
                LoadResult.Page(
                    data = response.body()?.data?.results?.map { it.toDomain() } ?: emptyList(),
                    prevKey = params.key ?: FIRST_PAGE_INDEX,
                    nextKey = params.key?.plus(1) ?: FIRST_PAGE_INDEX.plus(1)
                )
            } else {
                throw IllegalStateException(DEFAULT_ERROR)
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    private companion object {
        const val FIRST_PAGE_INDEX = 1
        const val DEFAULT_ERROR = "Something wrong"
    }
}