package com.example.tododash.navigation

import androidx.navigation.NavHostController
import com.example.tododash.util.Action
import com.example.tododash.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    // when we go from List to Task screen we do not want to pop off the List screen
    // from our backstack, we want to keep it alive
    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}