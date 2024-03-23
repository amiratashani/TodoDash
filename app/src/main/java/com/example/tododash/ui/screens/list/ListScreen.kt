package com.example.tododash.ui.screens.list

import ListAppBar
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tododash.R
import com.example.tododash.ui.theme.fabBackgroundColor
import com.example.tododash.ui.viewmodels.SharedViewModel
import com.example.tododash.util.SearchAppBarState


@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {

    LaunchedEffect(key1 = true) {
        Log.d("ListScreen", "LaunchedEffect triggered")
        sharedViewModel.getAllTasks()
    }

    val action by sharedViewModel.action

    val allTasks by sharedViewModel.allTasks.collectAsState()
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    sharedViewModel.handleDatabaseActions(action)

    Scaffold(
        content = { ListContent(allTasks = allTasks, navigateToTaskScreen = navigateToTaskScreen) },
        topBar = { ListAppBar(sharedViewModel,
            searchAppBarState,
            searchTextState,
            sharedViewModel::onSearchClicked, {}) },
        floatingActionButton = { ListFab(navigateToTaskScreen) }
    )

}

@Composable
fun ListFab(onFabClicked: (taskId: Int) -> Unit) {
    FloatingActionButton(
        onClick = { onFabClicked(-1) },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button),
            tint = Color.White
        )
    }
}