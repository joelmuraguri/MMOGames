package com.joel.core


sealed class NavRoutes(val route: String) {
    object GamesListScreen: NavRoutes("games_list_screen")
    object GamesDetailScreen: NavRoutes("games_detail_screen")
}