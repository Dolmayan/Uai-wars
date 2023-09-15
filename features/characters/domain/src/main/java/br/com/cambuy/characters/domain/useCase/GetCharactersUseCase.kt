package br.com.cambuy.characters.domain.useCase

import androidx.paging.PagingData
import br.com.cambuy.characters.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {
    suspend operator fun invoke(textSearch: String) : Flow<PagingData<Character>>
}