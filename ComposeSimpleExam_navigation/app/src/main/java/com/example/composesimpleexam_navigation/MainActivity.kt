package com.example.composesimpleexam_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            
            NavHost(
                navController = navController,
                startDestination = "first") {
                composable("first") {
                    FirstScreen(navController)
                }
                composable("second") {
                    SecondScreen(navController)
                }
                composable("third/{text}") { backStackEntry ->
                    ThirdScreen(
                        navController = navController,
                        text = backStackEntry.arguments?.getString("text") ?: "",
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    val (text, setValue) = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("첫화면")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("second")
        }) {
            Text("두번째")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = text, onValueChange = setValue)

        Button(onClick = {
            if (text.isNotEmpty()){
                navController.navigate("third/$text")
            }
        }) {
            Text("세번째!")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("두번째 화면")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("뒤로가기")
        }
    }
}


@Composable
fun ThirdScreen(navController: NavController, text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("세번째 화면")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text)

        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("뒤로가")
        }
    }
}

