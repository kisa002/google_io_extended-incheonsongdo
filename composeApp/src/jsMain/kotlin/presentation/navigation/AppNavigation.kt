package presentation.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import presentation.screen.about.AboutScreen
import presentation.screen.home.HomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        composable(route = NavRoutes.Home.route) {
            HomeScreen()
        }

        composable(route = NavRoutes.About.route) {
            AboutScreen()
        }

        composable(route = NavRoutes.Sessions.route) {
            Text("SESSIONS")
        }
    }
}