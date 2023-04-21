package com.example.composechapter6.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ResData(
    @DrawableRes val imageRes: Int,
    @StringRes val text: Int
)
