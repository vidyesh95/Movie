package com.vidyesh.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.vidyesh.movie.ui.MovieTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MovieTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = Color.Yellow) {
            /*Greeting("Android")*/
            MyScreenContent()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Composable
fun Counter() {

    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text("I've been clicked ${count.value} times")
    }
}

@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    /*MovieTheme {
        Greeting("Android")
    }*/
    MyApp()
}