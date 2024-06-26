sealed class NavRoutes(val route: String) {
    data object Home : NavRoutes("home")
    data object About : NavRoutes("about")
    data object Sessions : NavRoutes("sessions")
}