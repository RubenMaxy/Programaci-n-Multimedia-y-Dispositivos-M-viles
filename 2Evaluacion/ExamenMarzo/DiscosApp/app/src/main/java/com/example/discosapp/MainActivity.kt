package com.example.discosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.discosapp.navigation.AppNavigation
import com.example.discosapp.ui.theme.DiscosAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiscosAppTheme {
                AppNavigation()
            }
        }
    }
}