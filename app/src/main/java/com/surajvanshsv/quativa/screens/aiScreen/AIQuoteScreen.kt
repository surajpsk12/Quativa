@file:Suppress("DEPRECATION")

package com.surajvanshsv.quativa.screens.aiScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.surajvanshsv.quativa.screens.home.BottomNavigationBar
import com.surajvanshsv.quativa.screens.home.QuoteCardHome
import com.surajvanshsv.quativa.sharecard.ShareQuoteCardItem
import com.surajvanshsv.quativa.sharecard.saveBitmapToGallery
import com.surajvanshsv.quativa.sharecard.shareBitmap
import com.surajvanshsv.quativa.viewmodels.AIQuoteViewModel
import dev.shreyaspatil.capturable.Capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiQuoteScreen(
    navController: NavController,
    quoteAIQuoteViewModel: AIQuoteViewModel = hiltViewModel(),
){

    val quote by quoteAIQuoteViewModel.aiQuote.collectAsState()
    val isLoading by quoteAIQuoteViewModel.isLoading.collectAsState()
    val moods: List<String> = listOf("Motivated", "Sad", "Anxious", "Powerful", "Peaceful" , "Love")

    var selectedMood by remember { mutableStateOf("") }

    val context = LocalContext.current

    val captureController = rememberCaptureController()
    var shareAction by remember { mutableStateOf("DOWNLOAD") }

    Box(modifier = Modifier.size(0.dp)) {
        Capturable(
            controller = captureController,
            onCaptured = { bitmap, error ->
                bitmap?.let {
                    val androidBitmap = it.asAndroidBitmap()
                    if (shareAction == "SHARE") {
                        shareBitmap(context, androidBitmap)
                    } else {
                        saveBitmapToGallery(context, androidBitmap, "Quativa_${System.currentTimeMillis()}")
                    }
                }
            }
        ) {
            quote?.let {
                ShareQuoteCardItem(
                    quote = it,
                    modifier = Modifier
                        .width(360.dp)
                        .height(640.dp)
                )
            }
        }
    }

    Scaffold(
        bottomBar = {BottomNavigationBar(navController = navController)}
    ) {
        padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Color.Black, Color(0xFF305478))))
                .padding(padding)
        ) {
            Text(
                text = "How are you feeling?",
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )

            LazyRow(
                modifier =Modifier.padding(8.dp)
            ) {
                items(moods){mood ->
                    FilterChip(
                        selected = selectedMood == mood,
                        onClick = {
                            selectedMood = mood
                            quoteAIQuoteViewModel.generateQuoteGroq(mood)
                        },
                        label = {
                            Text(mood,
                            color = if (selectedMood == mood) Color.Black else Color.White)
                                },
                        modifier = Modifier.padding(4.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF40C3FF),
                            labelColor = Color.White
                        )
                    )

                }
            }

            if(isLoading){
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color.White)
                }
            }

            quote?.let { aiQuote ->
                QuoteCardHome(
                    quote = aiQuote,
                    onLikeClick = { quoteAIQuoteViewModel.saveAiQuote(aiQuote) },
                    onShareClick = {
                        shareAction = "SHARE"
                        captureController.capture()
                    },
                    onDownloadClick = {
                        shareAction = "DOWNLOAD"
                        captureController.capture()
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                )
            }


        }

    }

}