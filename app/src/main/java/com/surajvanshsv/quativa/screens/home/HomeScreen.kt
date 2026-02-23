package com.surajvanshsv.quativa.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.R
import com.surajvanshsv.quativa.model.Quote

val InkutAntiqua = FontFamily(
    Font(R.font.inknutantiquaregular, FontWeight.Normal)
)

@Composable
fun HomeScreen(){
    Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
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
                modifier = Modifier.alpha(0.7f)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 62.sp,
                fontFamily = FontFamily.Cursive
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
                lineHeight = 100.sp,
                maxLines = 1
            )
            // card
            QuoteCardHome(quote = Quote(
                author = "Suraj",
                body = "This is a quote which is very long and its hist so long ",
                id = 1
            ),
                modifier = Modifier.padding(start = 18.dp, end = 18.dp, bottom = 130.dp)
            )



        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}

