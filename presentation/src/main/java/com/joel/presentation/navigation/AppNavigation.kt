package com.joel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joel.core.NavRoutes
import com.joel.presentation.game_list.GamesListScreen
import com.joel.presentation.games_details.GamesDetailsScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.GamesListScreen.route){
        composable(route = NavRoutes.GamesListScreen.route){
            GamesListScreen(navController = navController)
        }
        composable(route = NavRoutes.GamesDetailScreen.route + "/{id}"){
            GamesDetailsScreen()
        }
    }

}