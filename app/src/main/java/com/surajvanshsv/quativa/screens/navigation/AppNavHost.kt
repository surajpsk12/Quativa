package com.surajvanshsv.quativa.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.surajvanshsv.quativa.repository.QuoteRepository
import com.surajvanshsv.quativa.retrofit.RetrofitInstance
import com.surajvanshsv.quativa.screens.home.HomeScreen
import com.surajvanshsv.quativa.screens.profile.ProfileScreen
import com.surajvanshsv.quativa.screens.saved.SavedScreen
import com.surajvanshsv.quativa.splashscreen.SplashScreen
import com.surajvanshsv.quativa.viewmodels.QuoteViewModel

@Composable
fun AppNavHost(){
    val navController = rememberNavController()
    val apiInterface = RetrofitInstance().apiInterface
    val repository = QuoteRepository(apiInterface)
    val viewModel = QuoteViewModel(repository)
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