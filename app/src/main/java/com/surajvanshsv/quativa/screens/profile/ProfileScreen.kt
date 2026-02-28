package com.surajvanshsv.quativa.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.surajvanshsv.quativa.R
import com.surajvanshsv.quativa.screens.home.BottomNavigationBar
import com.surajvanshsv.quativa.viewmodels.QuoteViewModel

@Composable
fun ProfileScreen(
    navController: NavController
){
    // Using a list for the social cards data
    val cardList = listOf(
        SocialsCardData(
            icon = R.drawable.mdi_linkedin,
            name = "LinkedIn"
        ), SocialsCardData(
            icon = R.drawable.github,
            name = "Github"
        ),
        SocialsCardData(
            icon = R.drawable.instalogo2,
            name = "Instagram"
        ),
        SocialsCardData(
            icon = R.drawable.pajamas_twitter,
            name = "Twitter"
        ),
        SocialsCardData(
            icon = R.drawable.discordlogo,
            name = "Discord"
        ),
        SocialsCardData(
            icon = R.drawable.aboutlogo,
            name = "About App"
        )
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient( 
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


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 32.dp, top = 16.dp)
            ) {
                items(cardList) { cardItem ->
                    SocialsCard(
                        icon = cardItem.icon,
                        name = cardItem.name,
                        onClick = { /* Handle click */ }
                    )
                }
            }
        }
    }
}

data class SocialsCardData(
    val icon: Int,
    val name: String
)


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    // Use a dummy NavController for the preview
    ProfileScreen(navController = NavController(LocalContext.current))

}