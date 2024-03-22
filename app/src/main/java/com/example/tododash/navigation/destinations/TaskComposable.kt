package com.example.tododash.navigation.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.tododash.ui.screens.task.TaskScreen
import com.example.tododash.ui.viewmodels.SharedViewModel
import com.example.tododash.util.Action
import com.example.tododash.util.Constants
import com.example.tododash.util.Constants.TASK_ARGUMENT_KEY


fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(Constants.TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId)
        val selectedTask by sharedViewModel.selectTask.collectAsState()

        TaskScreen(navigateToListScreen = navigateToListScreen,selectedTask)
    }
}
