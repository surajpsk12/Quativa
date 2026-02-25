package com.surajvanshsv.quativa.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surajvanshsv.quativa.R

@Composable
fun DeveloperCard(
    title : String ,
    desc : String
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(26.dp),
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
                .size(120.dp)
        )
            // title
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = androidx.compose.ui.graphics.Color.White, // Added white color to be visible on dark background
            modifier = Modifier.padding(top = 16.dp)
        )
            // desc
        Text(
            text = desc,
            style = MaterialTheme.typography.titleMedium,
            textDecoration = TextDecoration.Underline,
            color = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.7f), // Added white color
            modifier = Modifier.padding(top = 8.dp)
        )

    }

}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun DeveloperCardPreview()
{
    DeveloperCard(
        title = "Suraj Vansh",
        desc = "Developer "
    )
}