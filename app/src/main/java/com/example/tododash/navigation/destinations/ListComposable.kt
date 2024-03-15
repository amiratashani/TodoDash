package com.example.tododash.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.tododash.ui.viewmodels.SharedViewModel
import com.example.tododash.util.Action
import com.example.tododash.util.Constants.LIST_ARGUMENT_KEY
import com.example.tododash.util.Constants.LIST_SCREEN


fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) { type = NavType.StringType })
    ) {}
}