package br.com.cambuy.uai.design_system.screens.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cambuy.uai.core.util.coreStrings
import br.com.cambuy.uai.design_system.theme.UaiWarsTheme
import br.com.cambuy.uai.design_system.theme.spacing

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    @StringRes buttonText: Int,
    icon: ImageVector? = null,
    onClick: () -> Unit,
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = MaterialTheme.spacing.extraLarge),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            icon?.let {
                Icon(
                    imageVector = icon,
                    contentDescription = null
                )
            }

            Text(
                text = stringResource(id = buttonText),
                style = MaterialTheme.typography.bodyLarge.copy(),
            )
        }
    }
}

@Preview
@Composable
fun ButtonComponentPreview() {
    UaiWarsTheme {
        ButtonComponent(buttonText = coreStrings.try_again) {}
    }
}