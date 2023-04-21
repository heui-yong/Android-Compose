package com.example.composechapter9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composechapter9.home.Home
import com.example.composechapter9.ui.theme.ComposeChapter9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter9Theme {
                Home()
            }
        }
    }
}