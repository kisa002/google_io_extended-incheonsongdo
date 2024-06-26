import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        composable(route = NavRoutes.Home.route) {
            Text("HOME")
        }

        composable(route = NavRoutes.About.route) {
            Text("ABOUT")
        }

        composable(route = NavRoutes.Sessions.route) {
            Text("SESSIONS")
        }
    }
}