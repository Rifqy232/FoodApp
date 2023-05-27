package com.mry.foodapp.ui.screen

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Detail: Screen("home/{foodId}") {
        fun createRoute(foodId: String) = "home/$foodId"
    }
    object About: Screen("about")
}
