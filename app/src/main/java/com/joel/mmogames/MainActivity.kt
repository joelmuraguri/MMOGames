package com.joel.mmogames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.joel.mmogames.ui.theme.MMOGamesTheme
import com.joel.presentation.game_list.GamesListScreen
import com.joel.presentation.navigation.AppNavigation
import com.joel.presentation.onboarding.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }


        setContent {
            MMOGamesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val screen by splashViewModel.startDestination
                    val navController = rememberNavController()
                    AppNavigation(navController = navController, startDestination = screen)
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