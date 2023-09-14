package br.com.cambuy.uai.characters.presentation

import androidx.paging.PagingData
import br.com.cambuy.characters.domain.model.Character
import br.com.cambuy.uai.design_system.StateOfUi
import kotlinx.coroutines.flow.Flow

data class CharactersState(
    val stateOfUi: StateOfUi = StateOfUi.View,
    val listOfCharacters: Flow<PagingData<Character>>? = null
)