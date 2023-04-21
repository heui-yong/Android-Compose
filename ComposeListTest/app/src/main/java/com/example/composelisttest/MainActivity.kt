package com.example.composelisttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelisttest.ui.theme.ComposeListTestTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val scrollState = rememberScrollState() 스크롤 정보를 기억해 줌

//            Column(
//                modifier = Modifier
//                    .background(color = Color.Green)
//                    .fillMaxWidth()
//                    .verticalScroll(scrollState) // 스크롤이 가능하게 만들어 줌
//            ) {
//                for (i in 1..50){
//                    Text("숫자 $i")
//                }
//            }
                LazyColumn(
                    modifier = Modifier
                        .background(color = Color.Green)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp  ),
                    verticalArrangement = Arrangement.spacedBy(8.dp) // 아이템 간격 지정
                ) {
                    item {
                        Text("Header")
                    }
                    items(50){ index ->  // 50개 짜리 아이템을 만든다
                        Text("숫자 $index")
                    }
                    item {
                        Text("Footer")
                    }
            }
        }
    }
}