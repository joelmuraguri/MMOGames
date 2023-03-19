package com.joel.mmogames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joel.mmogames.ui.theme.MMOGamesTheme
import com.joel.presentation.game_list.GamesListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MMOGamesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GamesListScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = " $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MMOGamesTheme {
        Greeting("Android")
    }
}