package com.example.composechapter8.home

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composechapter8.R
import com.example.composechapter8.data.PostRepo
import com.example.composechapter8.home.theme.JetNewsTheme

@Composable
fun Home() {
    val randomPostInfo = remember { PostRepo.getFeaturedPost() }
    val posts = remember { PostRepo.getPosts() }
    Log.e("aaaaaa", "id : ${randomPostInfo.imageId}")
    JetNewsTheme(darkTheme = false) {
        Scaffold(
            topBar = { AppBar() }
        ) { padding ->
            LazyColumn(contentPadding = padding) {
                item {
                    TextSection(R.string.top)
                }
                item {
                    TopStorySection(randomPostInfo = randomPostInfo, modifier = Modifier.padding(16.dp))
                }
                item {
                    TextSection(R.string.popular)
                    Spacer(modifier = Modifier.padding(bottom = 16.dp))
                }
                items(posts) { item ->
                    PopularItem(post = item, modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp))
                }
            }
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        },
        title = {
            Text(text = stringResource(R.string.app_title))
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}


@Composable
fun TextSection(
    @StringRes text: Int
) {
    Text(
        text = stringResource(text),
        fontSize = 16.sp,
        modifier = Modifier
            .background(color = Color.Gray)
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp)
        )
}

@Preview
@Composable
fun HomePreview() {
    JetNewsTheme {
        Home()
    }
}