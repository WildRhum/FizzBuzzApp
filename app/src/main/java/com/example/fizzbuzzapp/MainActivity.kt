package com.example.fizzbuzzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fizzbuzzapp.ui.Screen
import com.example.fizzbuzzapp.ui.fizzbuzz.FizzBuzzScreen
import com.example.fizzbuzzapp.ui.fizzbuzz.FizzBuzzViewModel
import com.example.fizzbuzzapp.ui.form.FormScreen
import com.example.fizzbuzzapp.ui.form.FormViewModel
import com.example.fizzbuzzapp.ui.theme.FizzBuzzAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FizzBuzzAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.FormScreen.route
                    ) {
                        composable(
                            route = Screen.FormScreen.route
                        ) {
                            val formViewModel = hiltViewModel<FormViewModel>()
                            FormScreen(navController, formViewModel)
                        }
                        composable(
                            route = Screen.FizzBuzzScreen.route
                        ) {
                            val fizzBuzzViewModel = hiltViewModel<FizzBuzzViewModel>()
                            val parentEntry = remember(it) {
                                navController.getBackStackEntry(Screen.FormScreen.route)
                            }
                            val formViewModel = hiltViewModel<FormViewModel>(parentEntry)
                            FizzBuzzScreen(fizzBuzzViewModel, formViewModel)
                        }
                    }
                }
            }
        }
    }
}