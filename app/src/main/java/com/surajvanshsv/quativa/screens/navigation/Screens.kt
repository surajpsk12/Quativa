package com.surajvanshsv.quativa.screens.navigation

sealed class Screens(val route:String) {

    object Home : Screens("home")
    object Saved : Screens("saved")
    object Profile : Screens("profile")



}