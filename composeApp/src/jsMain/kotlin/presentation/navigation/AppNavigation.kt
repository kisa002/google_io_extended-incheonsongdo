package presentation.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import data.Session
import presentation.screen.about.AboutScreen
import presentation.screen.home.HomeScreen

@Composable
fun AppNavigation(navController: NavHostController, onShowSessionDetail: (Session) -> Unit) {
    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        composable(route = NavRoutes.Home.route) {
            HomeScreen(onShowSessionDetail = onShowSessionDetail)
        }

        composable(route = NavRoutes.About.route) {
            AboutScreen()
        }

        composable(route = NavRoutes.Sessions.route) {
            Text("SESSIONS")
        }
    }
}