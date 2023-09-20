package br.com.cambuy.uai.characters.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import br.com.cambuy.uai.characters.presentation.characters.CharacterItem
import br.com.cambuy.uai.design_system.StateOfUi
import br.com.cambuy.uai.design_system.screens.GenericErrorScreen
import br.com.cambuy.uai.design_system.screens.ProgressIndicator

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel(),
    navigation: NavHostController
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(CharactersEvent.FetchListOfCharacters(""))
    }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is CharactersUiEvent.NavigateTo -> navigation.navigate(event.route.route)
                is CharactersUiEvent.NavigateUp -> navigation.popBackStack()
            }
        }
    }

    when (val stateOfUi = state.stateOfUi) {
        is StateOfUi.Error -> GenericErrorScreen(action = stateOfUi.action)
        is StateOfUi.Loading -> ProgressIndicator()
        is StateOfUi.View -> CharactersScreen(state, viewModel::onEvent)
    }
}

@Composable
private fun CharactersScreen(
    state: CharactersState,
    onEvent: (CharactersEvent) -> Unit
) {

    val lazyPagingItems = state.listOfCharacters?.collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

        lazyPagingItems?.let {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsIndexed(lazyPagingItems) { _, item ->
                    item?.let { model ->
                        CharacterItem(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            model = model
                        ) { characterId ->
                            onEvent(CharactersEvent.NavigateToCharactersDetail(characterId))
                        }
                    }
                }
            }
        }
    }
}