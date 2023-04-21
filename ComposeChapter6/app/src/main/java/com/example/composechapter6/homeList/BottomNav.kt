package com.example.composechapter6.homeList

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.composechapter6.R

@Composable
fun BottomNavView(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier=modifier
    ) {
        BottomNavigationItem(
            icon = {
                   Icon(imageVector = Icons.Default.Home,
                       contentDescription = null
                   )
            },
            label = {
                    Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
    }
}