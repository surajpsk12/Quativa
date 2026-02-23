package com.surajvanshsv.quativa.screens.home

import android.view.RoundedCorner
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.R
import com.surajvanshsv.quativa.model.Quote

@Composable
fun QuoteCardHome(
    quote: Quote,
    modifier: Modifier,
){
    val borderGradient = Brush.verticalGradient(
        0.0002f to Color(0xFF80919C), // 0.02%
        1.0f to Color(0xFFCAD2DA)     // 127.95% (Clamped to 1.0f for display)
    )



    Card(
        modifier = modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                brush = borderGradient,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column(modifier=Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            // 1. Opening Quote
            Row( modifier = Modifier.padding(start = 10.dp, top = 18.dp)) {
                Text(
                    text = ".",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 60.sp,
                    color = Color.Red,
                    lineHeight = 20.sp
                )
                Text(
                    text = ".",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 60.sp,
                    color = Color.Yellow,
                    lineHeight = 20.sp
                )
                Text(
                    text = ".",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 60.sp,
                    color = Color.Green,
                    lineHeight = 20.sp
                )

            }
            // 2. Quote Body
            Text(
                text = quote.body,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
//            // 3. Closing Quote
//            Text(
//                text = "",
//                fontWeight = FontWeight.Bold,
//                fontStyle = FontStyle.Italic,
//                fontSize = 60.sp,
//                lineHeight = 20.sp,
//                color = Color.White,
//                textAlign = TextAlign.End,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(end = 10.dp)
//
//            )
            // 4. Author
            Text(
                text = "- ${quote.author}",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 28.sp,
                color = Color(0xFFE6EA67).copy(alpha = 0.8f),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 36.dp, top = 20.dp)
            )

            // like share and donwload button bar
            Spacer(modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
                    .padding(vertical = 10.dp),
            ) {
                // like button
                Icon(
                    painter = painterResource(id = R.drawable.likeicon01),
                    contentDescription = "like icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(27.dp)
                        .width(27.dp)
                )
                //share button
                Icon(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "like icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(27.dp)
                        .width(27.dp)
                )
                // download button
                Icon(
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = "like icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(27.dp)
                        .width(27.dp)
                )

            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuoteCardHomePreview(){
    QuoteCardHome(
        quote = Quote(
            author = "Suraj",
            body = "This is a quote which is very long and its hist so long ",
            id = 1
        ),
        modifier = Modifier
    )
}
