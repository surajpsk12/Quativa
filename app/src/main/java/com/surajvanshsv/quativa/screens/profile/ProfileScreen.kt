package com.surajvanshsv.quativa.screens.profile

import android.content.Intent
import android.net.Uri
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
import androidx.navigation.NavController
import com.surajvanshsv.quativa.R
import com.surajvanshsv.quativa.screens.home.BottomNavigationBar
import androidx.core.net.toUri

@Composable
fun ProfileScreen(
    navController: NavController,
){
    // Using a list for the social cards data
    val cardList = listOf(
        SocialsCardData(
            icon = R.drawable.email,
            name = "Email",
            url = "mailto:sk658139@gmail.com"
        ),
        SocialsCardData(
            icon = R.drawable.mdi_linkedin,
            name = "LinkedIn",
            url = "https://www.linkedin.com/in/surajvansh12/"
        ),
        SocialsCardData(
            icon = R.drawable.github,
            name = "Github",
            url = "https://github.com/surajpsk12"
        ),
        SocialsCardData(
            icon = R.drawable.instalogo2,
            name = "Instagram",
            url = "https://www.instagram.com/surajvansh12/"
        ),
        SocialsCardData(
            icon = R.drawable.pajamas_twitter,
            name = "Twitter",
            url = ""
        ),
        SocialsCardData(
            icon = R.drawable.aboutlogo,
            name = "About App",
            url = ""
        )
    )


    val context = LocalContext.current
    val openUrl = { url : String ->
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        context.startActivity(intent)

    }




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
                title = "Suraj Kumar",
                desc = "Android Developer"
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
                        onClick = {
                            if(cardItem.url.isNotEmpty()){
                                openUrl(cardItem.url)
                            }
                        }
                    )
                }
            }
        }
    }
}

data class SocialsCardData(
    val icon: Int,
    val name: String,
    val url: String,
)


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    // Use a dummy NavController for the preview
    ProfileScreen(navController = NavController(LocalContext.current))

}