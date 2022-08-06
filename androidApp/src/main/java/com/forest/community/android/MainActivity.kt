package com.forest.community.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.forest.community.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ticket.ui.theme.CommunityTheme
import com.forest.community.android.ui.Intro
import com.forest.community.android.ui.screens.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommunityTheme() {
                // A surface container using the 'background' color from the theme
                androidx.compose.material.Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = NavRoute.BinaryChoice.route,
        ) {
            composable(NavRoute.Intro.route) {
                Intro(navController = navController)
            }
            composable(NavRoute.Identification.route) {
                Identification(navController = navController)
            }
            composable(NavRoute.Search.route) {
                Search(navController = navController)
            }
            composable(NavRoute.Verification.route) {
                Verification(navController = navController)
            }

            composable(NavRoute.PhotoId.route) {
                PhotoId(navController = navController)
            }

            composable(NavRoute.BinaryChoice.route) {
                BinaryChoice(navController = navController)
            }
        }
    }
}