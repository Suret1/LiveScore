package com.suret.livescore.model

import androidx.fragment.app.Fragment

data class TabMenuModel(
    val fragments: List<Fragment>,
    val image: List<Int>,
    val title: List<String>
)
