package com.example.composechapter6.homeList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composechapter6.R
import com.example.composechapter6.data.ResData
import com.example.composechapter6.ui.theme.ComposeChapter6Theme

@Composable
fun CircleItemView(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(circleItemInfo) { item ->
            CircleItem(imageRes = item.imageRes, text = item.text)
        }
    }
}

private val circleItemInfo = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { ResData(it.first, it.second) }


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeChapter6Theme {
        CircleItemView()
    }
}