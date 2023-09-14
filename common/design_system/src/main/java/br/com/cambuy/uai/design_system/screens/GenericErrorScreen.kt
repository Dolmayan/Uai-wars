package br.com.cambuy.uai.design_system.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cambuy.uai.core.util.coreStrings
import br.com.cambuy.uai.design_system.drawableDesignSystem
import br.com.cambuy.uai.design_system.screens.components.ButtonComponent
import br.com.cambuy.uai.design_system.theme.UaiWarsTheme

@Composable
fun GenericErrorScreen(action: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {

        Image(
            modifier = Modifier
                .padding(top = 124.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = drawableDesignSystem.ic_warning),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            text = stringResource(id = coreStrings.error_screen_title),
            color = MaterialTheme.colorScheme.surface,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            text = stringResource(id = coreStrings.error_screen_description),
            color = MaterialTheme.colorScheme.surface,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonComponent(
            modifier = Modifier.padding(vertical = 24.dp),
            buttonText = coreStrings.try_again,
            icon = Icons.Default.Refresh,
            onClick = action
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenericErrorScreenPreview() {
    UaiWarsTheme {
        GenericErrorScreen {}
    }
}