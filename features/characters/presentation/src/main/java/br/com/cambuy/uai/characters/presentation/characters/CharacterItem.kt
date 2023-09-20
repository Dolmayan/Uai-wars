package br.com.cambuy.uai.characters.presentation.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.com.cambuy.characters.domain.model.Character
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    model: Character,
    onClick: (Int) -> Unit
) {

    Card(modifier = modifier
        .fillMaxWidth()
        .clickable { onClick(model.id) }) {
        Column(modifier.padding(16.dp)) {

            model.thumbnail?.let { thumbnail ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(thumbnail.path + "." + thumbnail.extension)
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Text(modifier = Modifier.padding(top = 12.dp), text = model.name)
            Text(modifier = Modifier.padding(top = 8.dp), text = model.description)
        }
    }
}