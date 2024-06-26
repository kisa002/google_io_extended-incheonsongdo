@file:OptIn(ExperimentalFoundationApi::class)

package presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import google_io_extended_incheonsongdo.composeapp.generated.resources.Res
import google_io_extended_incheonsongdo.composeapp.generated.resources.logo_gdg_web
import org.jetbrains.compose.resources.painterResource
import presentation.navigation.AppNavigation
import presentation.navigation.NavRoutes
import presentation.theme.Gray600
import presentation.theme.Gray700
import presentation.theme.GdgTheme

@Composable
fun App() {
    GdgTheme {
        val navController = rememberNavController()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(state = rememberScrollState())
        ) {
            val currentRoute by produceState(initialValue = NavRoutes.Home.route) {
                val listener = NavController.OnDestinationChangedListener { _, _, _ ->
                    value = navController.currentDestination?.route ?: NavRoutes.Home.route
                }
                navController.addOnDestinationChangedListener(listener)

                awaitDispose {
                    navController.removeOnDestinationChangedListener(listener)
                }
            }

            Header(
                logoContent = { Logo() },
                menuContent = {
                    Menu(text = "HOME", selected = currentRoute == NavRoutes.Home.route) {
                        navController.navigate(NavRoutes.Home.route)
                    }
                    Menu(text = "ABOUT", selected = currentRoute == NavRoutes.About.route) {
                        navController.navigate(NavRoutes.About.route)
                    }
                    Menu(text = "SESSIONS", selected = currentRoute == NavRoutes.Sessions.route) {
                        navController.navigate(NavRoutes.Sessions.route)
                    }
                }
            )

            AppNavigation(navController = navController)
        }
    }
}

@Composable
private fun Header(logoContent: @Composable () -> Unit, menuContent: @Composable () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 120.dp).padding(top = 48.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        logoContent()
        Row(horizontalArrangement = Arrangement.spacedBy(44.dp)) {
            menuContent()
        }
    }
}

@Composable
private fun Logo() {
    Image(
        painter = painterResource(Res.drawable.logo_gdg_web),
        contentDescription = "GDG Logo",
        modifier = Modifier.size(width = 122.dp, height = 50.dp)
    )
}

@Composable
private fun Menu(text: String, selected: Boolean, onClick: () -> Unit) {
    val color = if (selected) Gray700 else Gray600

    Column(modifier = Modifier.onClick(onClick = onClick)) {
        Text(
            text = text,
            modifier = Modifier.drawBehind {
                if (selected) {
                    drawLine(
                        color = color,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 4f
                    )
                }
            },
            color = color,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}