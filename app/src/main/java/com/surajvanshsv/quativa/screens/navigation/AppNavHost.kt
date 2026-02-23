package com.surajvanshsv.quativa.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.surajvanshsv.quativa.screens.home.HomeScreen
import com.surajvanshsv.quativa.screens.profile.ProfileScreen
import com.surajvanshsv.quativa.screens.saved.SavedScreen

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route,
        route = "root_graph"
    ){
        composable(Screens.Home.route){
            HomeScreen(
                    navController = navController
            )
        }
        composable(Screens.Saved.route){
            SavedScreen()
        }
        composable(Screens.Profile.route){
            ProfileScreen()
        }

    }
}