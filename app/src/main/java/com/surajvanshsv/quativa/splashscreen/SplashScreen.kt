package com.surajvanshsv.quativa.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onTimeOut : ()-> Unit
) {

    LaunchedEffect(Unit) {
        delay(2000)
        onTimeOut()
    }

    // 1. The root Box holds the gradient background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient( // Using verticalGradient for 180deg
                    0.2379f to Color(0xFF000000),
                    0.7215f to Color(0xFF23354C),
                    1.0f to Color(0xFF305478)
                )
            )
    ) {
        Image(
            painter = painterResource(R.drawable.img1),
            contentDescription = "splash image",
            modifier = Modifier.fillMaxSize().alpha(0.7f).scale(1.5f),

        )
        Text(
            text = "Quativa",
            color = Color.White,
            modifier = Modifier.alpha(0.7f)
                .align(Alignment.Center)
                .padding(top = 80.dp),
            fontSize = 72.sp,
            fontFamily = FontFamily.Cursive
        )
    }
}

