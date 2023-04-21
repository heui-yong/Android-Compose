package com.example.composechapter9.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composechapter9.R

@Composable
fun HomeTabBar(
    backgroundColor: Color,
    tabPage: TabPage,
    tabSelected: (tabPage: TabPage) -> Unit
) {
    TabRow(
        selectedTabIndex = tabPage.ordinal,
        backgroundColor = backgroundColor,
        indicator = { tabPositions ->
            HomeTabIndicator(tabPositions, tabPage)
        }
    ) {
        HomeTab(
            icon = Icons.Default.Home,
            tittle = stringResource(R.string.home),
            onClick = { tabSelected(TabPage.Home) }
        )
        HomeTab(
            icon = Icons.Default.Person,
            tittle = stringResource(R.string.work),
            onClick = {tabSelected(TabPage.Work)}
        )
    }
}

@Composable
fun HomeTabIndicator(
    tabPosition: List<TabPosition>,
    tabPage: TabPage
) {

}

@Composable
fun HomeTab(
    icon: ImageVector,
    tittle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = tittle)
    }
}