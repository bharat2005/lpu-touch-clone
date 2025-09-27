package com.example.lputouch.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.AppViewModal
import com.example.lputouch.ui.features.auth.authGraph
import com.example.lputouch.ui.features.general.generalGraph
import com.example.lputouch.ui.features.main.mainGraph
import com.example.lputouch.ui.features.notifications.notificationGraph
import com.example.lputouch.ui.features.profile.profileGraph
import com.example.lputouch.ui.features.residential.residentailGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPermissionsApi::class)
@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun AppRoot(viewModal: AppViewModal) {
    val navController : NavHostController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    LaunchedEffect(systemUiController) {
        systemUiController.setSystemBarsColor(
            color = Color(0xFF323232),
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = Color(0xFFF8F8F8)
        )
    }


    NavHost(
        startDestination = "auth",
        navController = navController,
        enterTransition = {
            fadeIn(
                animationSpec = tween(500)
            ) + slideInVertically(
                initialOffsetY = { it / 16 },
                animationSpec = tween(300)
            )
        }

    ) {
        authGraph(navController, viewModal)
        mainGraph(navController)
        generalGraph(navController)
        profileGraph(navController)
        residentailGraph(navController)
        notificationGraph(navController)



    }

}
