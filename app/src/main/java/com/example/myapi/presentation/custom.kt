package com.example.myapi.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    label: @Composable (() -> Unit)? = null,
    place: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.small,
) {
    OutlinedTextField(
        value = text,
        onValueChange = {
            onTextChange(it)
        },
        label = label,
        placeholder = place,
        shape = shape,
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun BMListItem(
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    secondaryText: @Composable (() -> Unit)? = null,
    singleLineSecondaryText: Boolean = true,
    overlineText: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    text: @Composable () -> Unit,
) {
    ListItem(
        modifier = Modifier,
        secondaryText = secondaryText,
        text = text,
        icon = icon,
        trailing = trailing
    )
}

@Composable
fun CustomCheckBox(
    checked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    text: String,
) {
    Row {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                onCheckChange(it)
            }
        )
        Text(text = text, Modifier.padding(10.dp))
    }
}