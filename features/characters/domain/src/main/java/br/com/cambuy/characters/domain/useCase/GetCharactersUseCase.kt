package br.com.cambuy.characters.domain.useCase

import br.com.cambuy.characters.domain.model.PeopleResponse
import br.com.cambuy.uai.core.util.Resource

interface GetCharactersUseCase {
    suspend operator fun invoke(page: Int) : Resource<PeopleResponse>
}