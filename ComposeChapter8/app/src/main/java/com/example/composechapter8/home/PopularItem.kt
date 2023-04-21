package com.example.composechapter8.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composechapter8.R
import com.example.composechapter8.data.Post
import com.example.composechapter8.data.PostRepo
import java.util.*

@Composable
fun PopularItem(
    post: Post,
    modifier: Modifier = Modifier) {
    Row(modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        ) {
        Image(
            painter = painterResource(post.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(shape = MaterialTheme.shapes.small)
        )
        Column(
            modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = post.title,
                fontSize = 16.sp
            )
            PostMetadata(post)
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .height(1.dp)
                .background(color = Color.Gray)
            )
        }
    }
}

@Composable
private fun PostMetadata(
    post: Post,
    modifier: Modifier = Modifier
) {
    val divider = "  •  "
    val tagDivider = "  "
    val text = buildAnnotatedString {
        append(post.metadata.date)
        append(divider)
        append(stringResource(R.string.read_time, post.metadata.readTimeMinutes))
        append(divider)
        post.tags.forEachIndexed { index, tag ->
            if (index != 0) {
                append(tagDivider)
            }
            append(" ${tag.uppercase(Locale.getDefault())} ")
        }
    }
    Text(
        text = text,
        fontSize = 12.sp,
        color = Color.Gray
    )
}

@Preview
@Composable
private fun Preview(){
    Surface() {
        val randomPostInfo = PostRepo.getFeaturedPost()
        PopularItem(randomPostInfo)
    }
}