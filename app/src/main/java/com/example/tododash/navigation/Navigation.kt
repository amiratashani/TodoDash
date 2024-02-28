package com.example.tododash.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tododash.navigation.destinations.listComposable
import com.example.tododash.navigation.destinations.taskComposable
import com.example.tododash.util.Constants.LIST_SCREEN


@Composable
fun SetupNavigation(navController: NavHostController) {

    val screen = remember(navController) {
        Screens(navController = navController)
    }
    
    NavHost(navController = navController, startDestination = LIST_SCREEN){
        listComposable(screen.task )
        taskComposable(screen.list)
    }
}