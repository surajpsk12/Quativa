package com.surajvanshsv.quativa.screens.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.surajvanshsv.quativa.model.Quote
import com.surajvanshsv.quativa.screens.home.BottomNavigationBar

@Composable
fun SavedScreen(
    navController : NavController
){

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Column(modifier = Modifier
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
                text = "Saved",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 36.dp).align(Alignment.CenterHorizontally),
                fontSize = 42.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold
            )
            // search bar
            MySearchBar(
                query = "",
                onQueryChange = {},
                onSearch = {},
                modifier = Modifier.padding(horizontal = 16.dp , vertical = 12.dp)
                    .align(Alignment.CenterHorizontally),

            )
            // cards list
            val listOfQuotes = listOf(
                Quote(
                    author = "Suraj",
                    body = "Dream big, work hard, and stay consistent even when no one is watching.",
                    id = 1
                ),
                Quote(
                    author = "Niraj",
                    body = "Success is built daily through small disciplined actions.",
                    id = 2
                ),
                Quote(
                    author = "Dhiraj",
                    body = "Your mindset decides whether obstacles stop you or shape you.",
                    id = 3
                ),
                Quote(
                    author = "Aman",
                    body = "Focus on progress, not perfection.",
                    id = 4
                ),
                Quote(
                    author = "Rahul",
                    body = "Hard times create stronger versions of ourselves.",
                    id = 5
                ),
                Quote(
                    author = "Ankit",
                    body = "Discipline will take you places motivation never can.",
                    id = 6
                ),
                Quote(
                    author = "Riya",
                    body = "Confidence grows when you keep promises to yourself.",
                    id = 7
                ),
                Quote(
                    author = "Sneha",
                    body = "Every expert was once a beginner who refused to quit.",
                    id = 8
                ),
                Quote(
                    author = "Karan",
                    body = "Consistency beats intensity in the long run.",
                    id = 9
                ),
                Quote(
                    author = "Priya",
                    body = "Your future depends on what you do today.",
                    id = 10
                )
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 32.dp, top = 16.dp)
            ) {
                items(listOfQuotes) { quote ->
                    QuotesCard(
                        quote = quote,
                        modifier = Modifier.fillMaxWidth()
                    )
                    }
             }

        }
    }

}




@Preview(showBackground = true)
@Composable
fun SavedScreenPreview(){
    val dummyNavController = NavController(LocalContext.current)
    SavedScreen( dummyNavController)
}