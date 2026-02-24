package com.surajvanshsv.quativa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.surajvanshsv.quativa.screens.navigation.AppNavHost
import com.surajvanshsv.quativa.ui.theme.QuativaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuativaTheme {
                AppNavHost()
                }
            }
        }

}


// ab saved screen design karo . almost same hia to sb cheej copy ho sakta hai .
// fir profile desing karo . uss dummy data everywhere if needed .


