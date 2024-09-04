package com.example.model4

import AuthViewModel
import MentorPage
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.example.model3.MentorDetails
import com.example.model3.MentorViewModel
import com.example.model3.PFmentor
import com.example.model4.Pages.LoginPage
import com.example.model4.Pages.SignupPage
import drawable.ChoicePF
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier,
                    authViewModel: AuthViewModel,
                    navController: NavController,
                    mentorViewModel: MentorViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ) {
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }

        composable("signup") {
            SignupPage(modifier, navController, authViewModel)
        }
        composable("choosing") {
            ChoicePF(navController)
        }
        composable("PFmentor") {
            PFmentor(navController, mentorViewModel)
        }
        composable("mentor_home") {
            MentorPage(navController , mentorDetails = MentorDetails())
        }
    }
}
