package com.surajvanshsv.quativa.screens.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.surajvanshsv.quativa.screens.home.HomeScreen
import com.surajvanshsv.quativa.screens.profile.ProfileScreen
import com.surajvanshsv.quativa.screens.saved.SavedScreen
import com.surajvanshsv.quativa.splashscreen.SplashScreen
import com.surajvanshsv.quativa.viewmodels.QuoteViewModel

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    val viewModel : QuoteViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = "splash",
        route = "root_graph"
    ){
        composable("splash") {
            SplashScreen(
                    onTimeOut = {
                        navController.navigate(Screens.Home.route){
                            popUpTo("splash"){
                                inclusive = true
                            }
                        }
                    }
            )
        }
        composable(Screens.Home.route){
            HomeScreen(
                navController = navController,
                quoteViewModel = viewModel
            )
        }
        composable(Screens.Saved.route){
            SavedScreen(navController)
        }
        composable(Screens.Profile.route){
            ProfileScreen(navController)
        }

    }
}