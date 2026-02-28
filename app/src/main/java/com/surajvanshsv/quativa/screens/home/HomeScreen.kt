package com.surajvanshsv.quativa.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.surajvanshsv.quativa.R
import com.surajvanshsv.quativa.viewmodels.QuoteViewModel

val InkutAntiqua = FontFamily(
    Font(R.font.inknutantiquaregular, FontWeight.Normal)
)

@Composable
fun HomeScreen(
    navController: NavController,
    quoteViewModel: QuoteViewModel = hiltViewModel(),
){

    // Fetch quote on first launch
    LaunchedEffect(Unit) {
        quoteViewModel.getQuote()
    }
    val quote by quoteViewModel.quote.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = Modifier.fillMaxSize()
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
            // Quativa Text
            Text(
                text = "Quativa",
                color = Color.White,
                modifier = Modifier
                    .alpha(0.7f)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 42.sp,
                fontFamily = FontFamily.Cursive,
                lineHeight = 42.sp
            )

            // Text Quote of the day
            Text(
                text = "Quote of the day",
                color = Color.White,
                modifier = Modifier
                    .padding(6.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 35.sp,
                fontFamily = InkutAntiqua,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle.Normal,
                lineHeight = 35.sp,
                maxLines = 1
            )
            // card

            QuoteCardHome(
                quote = quote,
                onLikeClick = { quote?.let { quoteViewModel.insertQuote(it) } },
                onShareClick = { /* Handle share click */ },
                onDownloadClick = { /* Handle download click */ },
                modifier = Modifier
                    .weight(1f) // This pushes the button to the bottom
                    .padding(start = 18.dp, end = 18.dp, top = 0.dp, bottom = 12.dp)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 32.dp, end = 18.dp)
                    .width(160.dp)
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(Color.White, Color.White)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
            ){
                Button(
                    onClick = { quoteViewModel.getQuote() },
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "New Quote",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = InkutAntiqua,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }



        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    val dummyNavController = NavController(LocalContext.current)
    HomeScreen(navController =dummyNavController )
}

