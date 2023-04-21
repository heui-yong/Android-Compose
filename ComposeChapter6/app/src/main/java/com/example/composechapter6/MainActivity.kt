package com.example.composechapter6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composechapter6.homeList.BottomNavView
import com.example.composechapter6.homeList.CardItemView
import com.example.composechapter6.homeList.CircleItemView
import com.example.composechapter6.homeList.SearchBar
import com.example.composechapter6.ui.theme.ComposeChapter6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
private fun MyApp() {
    ComposeChapter6Theme {
        Scaffold(
            bottomBar = {BottomNavView()}
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .background(color = Color.Gray)
        .fillMaxHeight()
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(R.string.align){
            CircleItemView()
        }
        HomeSection(R.string.favorite) {
            CardItemView()
        }
    }
}

@Composable
fun HomeSection(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Text(
        text = stringResource(text),
        modifier = Modifier
            .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
            .padding(horizontal = 16.dp)
    )
    content()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface() {
        HomeScreen()
    }
}