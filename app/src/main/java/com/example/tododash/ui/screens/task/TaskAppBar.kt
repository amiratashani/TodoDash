package com.example.tododash.ui.screens.task

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.tododash.R
import com.example.tododash.component.DisplayAlertDialog
import com.example.tododash.data.models.Priority
import com.example.tododash.data.models.ToDoTask
import com.example.tododash.ui.theme.topAppBarBackgroundColor
import com.example.tododash.ui.theme.topAppBarContentColor
import com.example.tododash.util.Action


@Composable
fun TaskAppBar(
    navigateToListScreen: (Action) -> Unit,
    selectedTask: ToDoTask?
) {
    if (selectedTask == null) {
        NewTaskAppBar(navigateToListScreen)
    } else {
        ExistingTaskAppBar(selectedTask = selectedTask, navigateToListScreen)
    }
}

@Composable
fun NewTaskAppBar(navigateToListScreen: (Action) -> Unit) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = stringResource(id = R.string.add_task),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(onBackClicked: (Action) -> Unit) {
    IconButton(
        onClick = {
            onBackClicked(Action.NO_ACTION)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_arrow),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun AddAction(onAddClicked: (Action) -> Unit) {
    IconButton(
        onClick = {
            onAddClicked(Action.ADD)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_task),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colors.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ExistingTaskAppBarActions(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        }
    )
}


@Composable
fun ExistingTaskAppBarActions(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit,

    ) {
    var openDialog by remember { mutableStateOf(false) }

    DisplayAlertDialog(
        title = "Remove ${selectedTask.title}?",
        message = "Are you sure you want to remove ${selectedTask.title}?",
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = { navigateToListScreen(Action.DELETE) }
    )

    DeleteAction(onDeleteClicked = {
        openDialog = true
    })
    UpdateAction(onUpdateClicked = navigateToListScreen)
}

@Composable
fun CloseAction(onCloseClicked: (Action) -> Unit) {
    IconButton(
        onClick = {
            onCloseClicked(Action.NO_ACTION)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Close Icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun DeleteAction(onDeleteClicked: () -> Unit) {
    IconButton(
        onClick = {
            onDeleteClicked()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete Icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun UpdateAction(onUpdateClicked: (Action) -> Unit) {
    IconButton(
        onClick = {
            onUpdateClicked(Action.UPDATE)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Update Icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
@Preview
fun PreviewNewTaskAppBar() {
    NewTaskAppBar(navigateToListScreen = {})
}

@Composable
@Preview
fun PreviewExistingTaskAppBar() {
    ExistingTaskAppBar(
        navigateToListScreen = {},
        selectedTask = ToDoTask(
            id = 0,
            title = "Luis",
            description = "The best one",
            priority = Priority.HIGH
        )
    )
}
