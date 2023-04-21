package com.example.composechapter9.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composechapter9.ui.theme.ComposeChapter9Theme
import com.example.composechapter9.ui.theme.Green300
import com.example.composechapter9.ui.theme.Purple100

enum class TabPage {
    Home, Work
}

@Composable
fun Home() {

    var tabPage by remember {
        mutableStateOf(TabPage.Home)
    }

    val backgroundColor by animateColorAsState(if(tabPage == TabPage.Home) Purple100 else Green300)

    Scaffold(
        topBar = {
            HomeTabBar(
                backgroundColor = backgroundColor,
                tabPage = tabPage,
                tabSelected = {tabPage = it}
            )
        },
        backgroundColor = backgroundColor,
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp),
            modifier = Modifier.padding(padding)
        ) {

        }
    }
}

