package br.com.cambuy.uai.wars.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import br.com.cambuy.uai.design_system.StateOfUi

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel(),
    navigation: NavHostController
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is CharactersUiEvent.NavigateTo -> navigation.navigate(event.route.route)
                is CharactersUiEvent.NavigateUp -> navigation.popBackStack()
            }
        }
    }

    when (val stateOfUi = state.stateOfUi) {
        is StateOfUi.Error -> {}
        is StateOfUi.Loading -> {}
        is StateOfUi.View -> CharactersScreen(state, viewModel::onEvent)
    }
}

@Composable
private fun CharactersScreen(
    state: CharactersState,
    onEvent: (CharactersEvent) -> Unit
) {

    Column {

    }
}