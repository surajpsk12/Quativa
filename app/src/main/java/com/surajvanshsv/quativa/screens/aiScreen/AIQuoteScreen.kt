@file:Suppress("DEPRECATION")

package com.surajvanshsv.quativa.screens.aiScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.surajvanshsv.quativa.screens.home.BottomNavigationBar
import com.surajvanshsv.quativa.screens.home.QuoteCardHome
import com.surajvanshsv.quativa.sharecard.ShareQuoteCardItem
import com.surajvanshsv.quativa.sharecard.saveBitmapToGallery
import com.surajvanshsv.quativa.sharecard.shareBitmap
import com.surajvanshsv.quativa.viewmodels.AIQuoteViewModel
import com.surajvanshsv.quativa.viewmodels.QuoteViewModel
import dev.shreyaspatil.capturable.Capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiQuoteScreen(
    navController: NavController,
    quoteAIQuoteViewModel: AIQuoteViewModel = hiltViewModel(),
    quoteViewModel: QuoteViewModel = hiltViewModel(),
) {
    val quote by quoteAIQuoteViewModel.aiQuote.collectAsState()
    val isLoading by quoteAIQuoteViewModel.isLoading.collectAsState()
   // val moods = listOf("Motivated", "Sad", "Anxious", "Powerful", "Peaceful", "Love")
    val moods = listOf(
        "😊 Happy",
        "⚡ Excited",
        "🔥 Motivated",
        "💕 Romantic",
        "💡 Inspired",
        "😌 Peaceful",
        "😢 Sad",
        "😞 Lonely",
        "😡 Angry",
        "😤 Frustrated",
        "😰 Anxious",
        "😓 Stressed",
        "😴 Tired",
        "🥱 Exhausted",
        "❤️ Loved"
    )

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
        bottomBar = { BottomNavigationBar(navController = navController) },
        containerColor = Color.Transparent
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Black, Color(0xFF1A2A3D), Color(0xFF305478))
                    )
                )
                .padding(padding)
        ) {
            // Header Section
            Column(modifier = Modifier.padding(start = 24.dp, top = 40.dp, end = 24.dp, bottom = 16.dp)) {
                Text(
                    text = "AI Wisdom",
                    color = Color(0xFF40C3FF),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )
                Text(
                    text = "How are you feeling?",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier
                .height(110.dp)
                .fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(moods) { mood ->
                    val isSelected = selectedMood == mood
                    Surface(
                        onClick = {
                            selectedMood = mood
                            quoteAIQuoteViewModel.generateQuoteGroq(mood)
                        },
                        shape = RoundedCornerShape(20.dp),
                        color = if (isSelected) Color(0xFF40C3FF) else Color.White.copy(alpha = 0.08f),
                        border = BorderStroke(
                            width = 1.dp,
                            color = if (isSelected) Color(0xFF40C3FF) else Color.White.copy(alpha = 0.2f)
                        ),
                        modifier = Modifier.animateContentSize()
                    ) {
                        Text(
                            text = mood,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                            color = if (isSelected) Color.Black else Color.White,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            fontSize = 15.sp
                        )
                    }
                }
            }

            // Content Area
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                if (isLoading) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            color = Color(0xFF40C3FF),
                            strokeWidth = 3.dp,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            "Consulting the stars...",
                            color = Color.White.copy(0.6f),
                            modifier = Modifier.padding(top = 16.dp),
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                } else {
                    quote?.let { aiQuote ->
                        // Re-using your beautiful QuoteCardHome
                        QuoteCardHome(
                            quote = aiQuote,
                            onLikeClick = { quoteViewModel.insertQuote(aiQuote) },
                            onShareClick = {
                                shareAction = "SHARE"
                                captureController.capture()
                            },
                            onDownloadClick = {
                                shareAction = "DOWNLOAD"
                                captureController.capture()
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                    } ?: run {
                        // Empty State
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = Color.White.copy(0.2f),
                                modifier = Modifier.size(80.dp)
                            )
                            Text(
                                "Select a mood to generate\nan AI-powered quote",
                                color = Color.White.copy(0.3f),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 16.dp),
                                lineHeight = 22.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

