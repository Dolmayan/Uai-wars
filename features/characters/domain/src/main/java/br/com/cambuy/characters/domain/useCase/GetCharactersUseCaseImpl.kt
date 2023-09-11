package br.com.cambuy.characters.domain.useCase

import br.com.cambuy.characters.domain.CharactersRepository
import br.com.cambuy.characters.domain.model.PeopleResponse
import br.com.cambuy.uai.core.util.Resource

internal class GetCharactersUseCaseImpl(
    private val repository: CharactersRepository
) : GetCharactersUseCase {

    override suspend fun invoke(page: Int): Resource<PeopleResponse> {
        return repository.getCharactersList(page)
    }
}