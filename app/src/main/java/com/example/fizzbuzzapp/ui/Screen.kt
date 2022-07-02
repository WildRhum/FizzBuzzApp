package com.example.fizzbuzzapp.ui

/**
 * The [Screen] Class contains all the Screen that can be displayed in the app
 * When we navigate, we use the [Screen.route] value
 **/
sealed class Screen(val route: String) {
    object FormScreen: Screen("form_screen")
}