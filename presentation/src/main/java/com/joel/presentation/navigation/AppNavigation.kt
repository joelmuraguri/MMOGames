package com.joel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joel.core.NavRoutes
import com.joel.presentation.game_list.GamesListScreen
import com.joel.presentation.games_details.GamesDetailsScreen
import com.joel.presentation.onboarding.views.OnBoardingScreens

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination : String
){

    NavHost(navController = navController, startDestination = startDestination){
        composable(route = NavRoutes.OnboardingScreen.route) {
            OnBoardingScreens(navController = navController)
        }
        composable(route = NavRoutes.GamesListScreen.route){
            GamesListScreen(navController = navController)
        }
        composable(route = NavRoutes.GamesDetailScreen.route + "/{id}"){
            GamesDetailsScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }

}