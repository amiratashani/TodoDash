package com.example.tododash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tododash.navigation.SetupNavigation
import com.example.tododash.ui.theme.TodoDashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoDashTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}

