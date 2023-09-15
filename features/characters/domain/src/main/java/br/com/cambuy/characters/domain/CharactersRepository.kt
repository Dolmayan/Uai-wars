package br.com.cambuy.characters.domain

import androidx.paging.PagingData
import br.com.cambuy.characters.domain.model.Character
import br.com.cambuy.uai.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun getCharactersList(textSearch: String): Flow<PagingData<Character>>
    suspend fun getCharactersById(id: Int): Resource<Character>
}