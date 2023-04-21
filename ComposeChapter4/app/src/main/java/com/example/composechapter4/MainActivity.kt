package com.example.composechapter4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composechapter4.ui.theme.ComposeChapter4Theme
import com.example.composechapter4.ui.theme.mainList.Cards
import com.example.composechapter4.ui.theme.mainList.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChapter4Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var showScreen by rememberSaveable {
        mutableStateOf(true)
    }
    Surface(modifier) {
        if (showScreen) {
            OnboardingScreen(onClickText = {showScreen = false})
        } else Cards()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeChapter4Theme {
        MyApp()
    }
}