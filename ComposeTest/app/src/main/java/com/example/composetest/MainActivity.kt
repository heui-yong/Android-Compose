package com.example.composetest


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Row -> 수평
                    Column(
                        modifier = Modifier
                            .fillMaxSize() //사이즈를 전체로 지정
                            .background(color = Color.Blue)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally, // 가운데 정렬
                    ) { // 수직
                        Text("Hello")
//                      Spacer(Modifier.width(16.dp)) 공간을 주는 컴포즈
                        Text("World")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true) //미리보기
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        Column(
            modifier = Modifier
                .background(color = Color.Blue),
            horizontalAlignment = Alignment.CenterHorizontally
        ) { // 수직
            Text("Hello")
            Text("World")
        }
    }
}
