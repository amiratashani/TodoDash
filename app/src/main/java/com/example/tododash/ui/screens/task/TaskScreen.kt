package com.example.tododash.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.tododash.data.models.ToDoTask
import com.example.tododash.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(navigateToListScreen: (Action) -> Unit, selectedTask: ToDoTask?) {

    Scaffold(
        topBar = { TaskAppBar(navigateToListScreen = navigateToListScreen,selectedTask) },
        content = {}
    )
}