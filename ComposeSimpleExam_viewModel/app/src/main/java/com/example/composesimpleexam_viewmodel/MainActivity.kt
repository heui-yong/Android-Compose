package com.example.composesimpleexam_viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composesimpleexam_viewmodel.ui.theme.ComposeSimpleExam_viewModelTheme


class MainActivity : ComponentActivity() {
//    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
//            val data = remember {
//                mutableStateOf("Hello")
//            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    viewModel.data.value,
                    fontSize = 30.sp
                )

                Button(onClick = {
                    viewModel.changeValue()
                }) {
                    Text("변경")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSimpleExam_viewModelTheme {

    }
}

class MainViewModel: ViewModel() {
    private val _data = mutableStateOf("Hello")
    val data: State<String> = _data

    fun changeValue() {
        _data.value = "World"
    }
}