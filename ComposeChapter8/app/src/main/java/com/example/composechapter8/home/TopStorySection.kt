package com.example.composechapter8.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composechapter8.data.Post
import com.example.composechapter8.data.PostRepo
import com.example.composechapter8.R
import java.util.*

@Composable
fun TopStorySection(
    randomPostInfo: Post,
    modifier: Modifier = Modifier
) {
    Card(modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(randomPostInfo.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .heightIn(min = 180.dp)
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            val padding = Modifier.padding(horizontal = 16.dp)
            Text(
                text = randomPostInfo.title,
                modifier = padding
            )
            Text(
                text = randomPostInfo.metadata.author.name,
                modifier = padding
            )
            PostMetadata(
                post = randomPostInfo,
                modifier = padding
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
    val tagStyle = MaterialTheme.typography.overline.toSpanStyle().copy(
        background = MaterialTheme.colors.primary.copy(alpha = 0.1f))
    val text = buildAnnotatedString {
        append(post.metadata.date)
        append(divider)
        append(stringResource(R.string.read_time, post.metadata.readTimeMinutes))
        append(divider)
        post.tags.forEachIndexed { index, tag ->
            if (index != 0) {
                append(tagDivider)
            }
            withStyle(tagStyle) {
                append(" ${tag.toUpperCase()} ")
                }
        }
    }
    Text(
        text = text,
        modifier = modifier
    )
}

@Preview
@Composable
private fun Preview(){
    Surface() {
        val randomPostInfo = PostRepo.getFeaturedPost()
        TopStorySection(randomPostInfo)
    }
}