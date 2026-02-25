package com.surajvanshsv.quativa.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.R





@Composable
fun DeveloperCard(
    title : String ,
    desc : String
){

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
            // image
        Image(
            painter = painterResource(R.drawable.devpic),
            contentScale = ContentScale.Crop,
            contentDescription = "developer image",
            modifier = Modifier
                .clip(CircleShape)
                .size(135.dp)
        )
            // title
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
            modifier = Modifier.padding(top = 16.dp)
        )
            // desc
        Text(
            text = desc,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
            modifier = Modifier.padding(top = 4.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun DeveloperCardPreview()
{
    DeveloperCard(
        title = "Suraj Vansh",
        desc = "sk658139@gmail.com "
    )
}