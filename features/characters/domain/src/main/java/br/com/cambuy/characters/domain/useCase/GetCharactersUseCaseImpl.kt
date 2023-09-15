package br.com.cambuy.characters.domain.useCase

import androidx.paging.PagingData
import br.com.cambuy.characters.domain.CharactersRepository
import br.com.cambuy.characters.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetCharactersUseCaseImpl @Inject constructor(
    private val repository: CharactersRepository
) : GetCharactersUseCase {

    override suspend fun invoke(textSearch: String): Flow<PagingData<Character>> {
        return repository.getCharactersList(textSearch)
    }
}