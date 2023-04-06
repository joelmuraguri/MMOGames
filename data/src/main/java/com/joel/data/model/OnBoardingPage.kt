package com.joel.data.model

import com.joel.data.R

sealed class OnBoardingPage(
    val title : String,
    val description : String,
    val image : Int
){
    object First : OnBoardingPage(
        title = "Multiplayer Gaming",
        description = "Get to interact with other players across the globe.",
        image = R.drawable.online_gaming
    )
    object Second : OnBoardingPage(
        title = "Theme Customization",
        description = "Character's personalized outfits and weapons can be customized",
        image = R.drawable.costume_theme
    )
    object Third : OnBoardingPage(
        title = "Discover Games",
        description = "Discover what you've played and search for what to play next! ",
        image = R.drawable.gaming_buddy
    )
}
