package com.example.myapi.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapi.domain.model.CustomUiModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomList(list: List<CustomUiModel>) {
    LazyColumn() {
        items(list) {
            ListItem(
                text = { Text(text = "test") },
                secondaryText = { Text(text = "tst tst") }
            )
            Spacer(modifier = Modifier.height(20.dp))


        }
    }
}