package com.example.composechapter1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composechapter1.ui.theme.ComposeChapter1Theme
import com.example.composechapter1.ui.theme.mainlist.Conversation
import com.example.composechapter1.ui.theme.mainlist.SampleData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Conversation(SampleData.conversationSample)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeChapter1Theme {
        Conversation(SampleData.conversationSample)
    }
}