package com.surajvanshsv.quativa.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.surajvanshsv.quativa.R

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    // 1. The root Box holds the gradient background
    Box(
        modifier = modifier
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
    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen()
}