package com.surajvanshsv.quativa.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.surajvanshsv.quativa.screens.home.BottomNavigationBar

@Composable
fun ProfileScreen(
    navController: NavController
){
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient( // Using verticalGradient for 180deg
                        0.2379f to Color(0xFF000000),
                        0.7215f to Color(0xFF23354C),
                        1.0f to Color(0xFF305478)
                    )
                )
                .padding(innerPadding)
        ) {
            // developer card 
            DeveloperCard(
                title = "Suraj Vansh",
                desc = "sk658139@gmail.com"
            )
            // socials cards


        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen(navController = NavController(LocalContext.current))

}