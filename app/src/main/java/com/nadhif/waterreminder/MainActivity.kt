package com.nadhif.waterreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val userViewModel: UserViewModel = viewModel()
            NavHost(navController = navController, startDestination = "user_input") {
                composable("user_input") { UserInputScreen(navController, userViewModel) }
                composable("water_tracker") { WaterTrackerScreen(navController, userViewModel) }
            }
        }
    }
}
