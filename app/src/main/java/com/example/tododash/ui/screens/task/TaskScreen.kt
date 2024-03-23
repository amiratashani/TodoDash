package com.example.tododash.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.tododash.data.models.Priority
import com.example.tododash.data.models.ToDoTask
import com.example.tododash.ui.viewmodels.SharedViewModel
import com.example.tododash.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = { TaskAppBar(navigateToListScreen = navigateToListScreen, selectedTask) },
        content = {
            TaskContent(
                title = title,
                onTitleChange = sharedViewModel::onTitleChange,
                description = description,
                onDescriptionChange = sharedViewModel::onDescriptionChange,
                priority = priority,
                onPrioritySelected = sharedViewModel::onPrioritySelected
            )
        }
    )
}