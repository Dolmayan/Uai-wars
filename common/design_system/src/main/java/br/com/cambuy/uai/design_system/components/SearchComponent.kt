package br.com.cambuy.uai.design_system.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.cambuy.uai.core.util.coreStrings
import br.com.cambuy.uai.design_system.drawableDesignSystem

@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    makeRequest: () -> Unit,
) {

    val focusManager = LocalFocusManager.current

    val startIcon = @Composable {
        Image(
            painter = painterResource(id = drawableDesignSystem.ic_search),
            contentDescription = stringResource(
                coreStrings.description_icon_search
            )
        )
    }

    val endIcon = @Composable {
        Image(
            modifier = Modifier.clickable { onValueChange("") },
            painter = painterResource(id = drawableDesignSystem.ic_close),
            contentDescription = stringResource(
                coreStrings.description_icon_close
            )
        )
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 40.dp),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        leadingIcon = startIcon,
        trailingIcon = if (value.isNotEmpty()) endIcon else null,
        singleLine = true,
        placeholder = {
            Text(
                style = MaterialTheme.typography.h2.copy(fontSize = 14.sp),
                text = stringResource(coreStrings.search)
            )
        },
        value = value,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                makeRequest()
            }
        ),
    )
}