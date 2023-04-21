package com.example.composesimpleexam_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()) {
    val (text, setText) = remember {
        mutableStateOf("Hello World")
    }

    var text1 = remember {
        mutableStateOf("Hello World")
    }

    var text2 by remember {
        mutableStateOf("Hello World")
    }

    val text3 = viewModel.data.observeAsState("")

    Column() {
        Text("Hello World")

        Button(onClick = {
            setText("변경")
            print(text)
            text1.value = "변경"
            print(text1)
            text2 = "변경"
            print(text2)

            viewModel.changeValue("변경")
        }) {
            Text("클릭")
        }

        TextField(value = text, onValueChange = setText)
    }
}

class MainViewModel: ViewModel() {
    private val _value = mutableStateOf("Hello World")
    val value: State<String> = _value

    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
        get() = _data

    fun changeValue(value: String) {
        _value.value = value
    }
}