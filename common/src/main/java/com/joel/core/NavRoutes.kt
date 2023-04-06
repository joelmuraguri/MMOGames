package com.joel.core


sealed class NavRoutes(val route: String) {

    object OnboardingScreen : NavRoutes("onboarding_screen")
    object GamesListScreen: NavRoutes("games_list_screen")
    object GamesDetailScreen: NavRoutes("games_detail_screen")
}