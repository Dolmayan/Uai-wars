package br.com.cambuy.characters.domain

import br.com.cambuy.characters.domain.model.PeopleResponse
import br.com.cambuy.uai.core.util.Resource

interface CharactersRepository {
    suspend fun getCharactersList(page: Int): Resource<PeopleResponse>
}