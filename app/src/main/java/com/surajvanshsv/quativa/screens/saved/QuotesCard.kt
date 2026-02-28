package com.surajvanshsv.quativa.screens.saved

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.R
import com.surajvanshsv.quativa.model.Quote

@Composable
fun QuotesCard(
    quote: Quote,
    modifier: Modifier,
    onDeleteClick: () -> Unit = {},
    onShareClick: () -> Unit = {}

){
    val borderGradient = Brush.verticalGradient(
        0.0002f to Color(0xFF80919C), // 0.02%
        1.0f to Color(0xFFCAD2DA)     // 127.95% (Clamped to 1.0f for display)
    )
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
            .border(
                width = 0.dp,
                brush = borderGradient ,
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
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(start = 4.dp)
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
                fontSize = 18.sp,
                color = Color.White,
                maxLines = 3,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            // 4. Author
            Text(
                text = "- ${quote.author}",
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
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.padding(8.dp)
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
                        .height(22.dp)
                        .width(22.dp)
                        .clickable(onClick = {})
                )
                //share button
                Icon(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "share icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(22.dp)
                        .width(22.dp)
                        .clickable(onClick = onShareClick)
                )

                //delete button
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .height(22.dp)
                        .width(22.dp)
                        .clickable(onClick = onDeleteClick)
                )


            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun QuotesCardPreview(){
    QuotesCard(
        quote = Quote(
            author = "Suraj",
            body = " quote 1 ",
            id = 1
        ),
        modifier = Modifier
    )
}