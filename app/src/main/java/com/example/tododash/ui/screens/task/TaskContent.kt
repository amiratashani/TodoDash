package com.example.tododash.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tododash.R
import com.example.tododash.component.PriorityDropDown
import com.example.tododash.data.models.Priority
import com.example.tododash.ui.theme.LARGE_PADDING
import com.example.tododash.ui.theme.MEDIUM_PADDING


@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { newTitle -> onTitleChange(newTitle) },
            label = { Text(text = stringResource(R.string.title)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = MaterialTheme.colors.background
        )
        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { newDescription -> onDescriptionChange(newDescription) },
            label = { Text(text = "") },
            textStyle = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview
fun PreviewTaskContent() {
    TaskContent(
        title = "Luis",
        onTitleChange = {},
        description = "Description related to title",
        onDescriptionChange = {},
        priority = Priority.HIGH,
        onPrioritySelected = {}
    )
}