package com.surajvanshsv.quativa.screens.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.R
import com.surajvanshsv.quativa.model.Quote

@Composable
fun QuoteCardHome(
    quote: Quote?,
    modifier: Modifier,
    onLikeClick: () -> Unit ,
    onShareClick: () -> Unit ,
    onDownloadClick : ()-> Unit
){
    val borderGradient = Brush.verticalGradient(
        0.0002f to Color(0xFF80919C), // 0.02%
        1.0f to Color(0xFFCAD2DA)     // 127.95% (Clamped to 1.0f for display)
    )

    var isLiked by remember(quote) { mutableStateOf(false) }





    Card(
        modifier = modifier
            .fillMaxSize()
            .border(
                width = 0.dp,
                brush = borderGradient,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.elevatedCardElevation(16.dp)
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
                text = quote?.body ?: "Loading today's inspiration...",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 22.sp,
                color = Color.White,
                maxLines = 5,
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
                text = "- ${quote?.author}",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                color = Color(0xFFE6EA67).copy(alpha = 0.8f),
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 36.dp, top = 20.dp)
            )
            // like share and download button bar
            Spacer(Modifier.weight(1f)) // this is for putting button in end
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
                    .padding(vertical = 10.dp),
            ) {
                // like button
                val likeIcon = if (isLiked) R.drawable.heart else R.drawable.likeicon01
                val iconTint = if (isLiked) Color.Red else Color.White
                Icon(
                    painter = painterResource(id = likeIcon),
                    contentDescription = "like icon",
                    tint = iconTint,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(22.dp)
                        .clickable{
                            isLiked = !isLiked
                            // Handle like button click
                            onLikeClick()
                        }
                )
                //share button
                Icon(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "like icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(22.dp)
                        .width(22.dp)
                        .clickable(onClick = onShareClick)
                )
                // download button
                Icon(
                    painter = painterResource(id = R.drawable.img_3),
                    contentDescription = "like icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(22.dp)
                        .width(22.dp)
                        .clickable(onClick = onDownloadClick)
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
        modifier = Modifier,
        onLikeClick = {},
        onShareClick = {},
        onDownloadClick = {}
    )
}
