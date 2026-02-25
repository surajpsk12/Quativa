package com.surajvanshsv.quativa.screens.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surajvanshsv.quativa.R

@Composable
fun SocialsCard(
    @DrawableRes icon : Int,
    name : String,
    onClick : () -> Unit
){

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .clickable(onClick = onClick), // Fixed: pass onClick directly instead of {onClick}
            elevation = CardDefaults.cardElevation(0.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(42.dp),
            border = BorderStroke(
                width = 2.dp,
                color = Color.White.copy(alpha = 0.8f)
            )
        ) {
            InnerSocialsCard(
                icon = icon,
                name = name
            )
        }
    }


@Composable
fun InnerSocialsCard(
    @DrawableRes icon : Int,
    name : String
){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        // icon
        Icon(
            painter = painterResource(icon),
            contentDescription = name,
            modifier = Modifier.padding(horizontal = 4.dp).size(24.dp),
            tint = Color.White
        )
        // name
        Text(
            text = name,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            modifier = Modifier.padding(horizontal = 4.dp),
            color = Color.White
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun SocialsCardPreview(){
    SocialsCard(
        icon = R.drawable.mdi_linkedin,
        name = "LinkedIn",
        onClick = {}
    )
}
