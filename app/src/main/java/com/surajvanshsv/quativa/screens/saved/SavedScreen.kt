@file:Suppress("UNCHECKED_CAST", "DEPRECATION")

package com.surajvanshsv.quativa.screens.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.surajvanshsv.quativa.model.Quote
import com.surajvanshsv.quativa.screens.home.BottomNavigationBar
import com.surajvanshsv.quativa.sharecard.ShareQuoteCardItem
import com.surajvanshsv.quativa.sharecard.shareBitmap
import com.surajvanshsv.quativa.viewmodels.QuoteViewModel
import dev.shreyaspatil.capturable.Capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController

@Composable
fun SavedScreen(
    navController: NavController,
    quoteViewModel: QuoteViewModel = hiltViewModel(),
){
    val listOfQuotes by quoteViewModel.allQuote.collectAsState(initial = emptyList())
    val context = LocalContext.current

    // 1. Controller and State for the "Active" quote to share
    val captureController = rememberCaptureController()
    var selectedQuoteToShare by remember { mutableStateOf<Quote?>(null) }

    // 2. Hidden Capture Area (Invisible to user)
    Box(modifier = Modifier.size(0.dp)) {
        Capturable(
            controller = captureController,
            onCaptured = { bitmap, error ->
                bitmap?.let {
                    shareBitmap(context, it.asAndroidBitmap())
                }
            }
        ) {
            // This template updates whenever selectedQuoteToShare changes
            selectedQuoteToShare?.let {
                ShareQuoteCardItem(
                    quote = it,
                    modifier = Modifier.width(360.dp).height(640.dp)
                )
            }
        }
    }



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
                    .padding(top = 36.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 42.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold
            )
            // search bar
//            MySearchBar(
//                query = "",
//                onQueryChange = {},
//                onSearch = {},
//                modifier = Modifier.padding(horizontal = 16.dp , vertical = 12.dp)
//                    .align(Alignment.CenterHorizontally),
//
//            )

            if(listOfQuotes.isEmpty()){
                Text(
                    text = "No Quotes Saved",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 36.dp)
                        .align(Alignment.CenterHorizontally),
                    fontSize = 42.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold
                )
            }else {
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
                            modifier = Modifier.fillMaxWidth(),
                            onShareClick = {
                                selectedQuoteToShare = quote
                                captureController.capture()
                            },
                            onDeleteClick = { quoteViewModel.deleteQuoteItem(quote) }
                        )
                    }
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