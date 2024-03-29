package com.example.tododash.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tododash.navigation.destinations.listComposable
import com.example.tododash.navigation.destinations.taskComposable
import com.example.tododash.ui.viewmodels.SharedViewModel
import com.example.tododash.util.Constants.LIST_SCREEN


@ExperimentalMaterialApi
@Composable
fun SetupNavigation(navController: NavHostController, sharedViewModel: SharedViewModel) {

    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {
        listComposable(navigateToTaskScreen = screen.task, sharedViewModel = sharedViewModel)
        taskComposable(sharedViewModel = sharedViewModel, navigateToListScreen = screen.list)
    }
}