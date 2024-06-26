@file:OptIn(ExperimentalFoundationApi::class)

package presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import data.Session
import google_io_extended_incheonsongdo.composeapp.generated.resources.Res
import google_io_extended_incheonsongdo.composeapp.generated.resources.logo_gdg_web
import org.jetbrains.compose.resources.painterResource
import presentation.component.DrawerLayout
import presentation.component.MenuBar
import presentation.component.MenuItem
import presentation.navigation.AppNavigation
import presentation.navigation.NavRoutes
import presentation.screen.home.SessionDetailAlert
import presentation.support.LocalBrowserSizeManager.LocalBrowserSize
import presentation.support.LocalBrowserSizeManager.browserSizeAsState
import presentation.support.ResponsiveContent
import presentation.support.toResponsive
import presentation.theme.GdgTheme
import presentation.theme.White

@Composable
fun App() {
    GdgTheme {
        val navController = rememberNavController()
        val browserSize by browserSizeAsState()
        var visibleDrawer by remember { mutableStateOf(false) }
        var selectedSession by remember { mutableStateOf<Session?>(null) }

        CompositionLocalProvider(LocalBrowserSize provides browserSize) {
            val currentRoute by produceState(initialValue = NavRoutes.Home.route) {
                val listener = NavController.OnDestinationChangedListener { _, _, _ ->
                    value = navController.currentDestination?.route ?: NavRoutes.Home.route
                }
                navController.addOnDestinationChangedListener(listener)

                awaitDispose {
                    navController.removeOnDestinationChangedListener(listener)
                }
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                Column(
                    modifier = Modifier
                        .widthIn(max = 1440.dp)
                        .fillMaxSize()
                        .background(White)
                        .verticalScroll(state = rememberScrollState())
                ) {
                    Header(
                        logoContent = { Logo { navController.navigate(NavRoutes.Home.route) } },
                        menuContent = {
                            ResponsiveContent(
                                desktopContent = {
                                    Row(horizontalArrangement = Arrangement.spacedBy(44.dp)) {
                                        MenuItem(text = "HOME", selected = currentRoute == NavRoutes.Home.route) {
                                            navController.navigate(NavRoutes.Home.route)
                                        }
                                        MenuItem(text = "ABOUT", selected = currentRoute == NavRoutes.About.route) {
                                            navController.navigate(NavRoutes.About.route)
                                        }
                                    }
                                },
                                mobileContent = {
                                    MenuBar {
                                        visibleDrawer = true
                                    }
                                }
                            )
                        }
                    )

                    AppNavigation(
                        navController = navController,
                        onShowSessionDetail = { session: Session ->
                            selectedSession = session
                        }
                    )
                }

                SessionDetailAlert(
                    selectedSession = selectedSession,
                    onDismissRequest = { selectedSession = null }
                )

                DrawerLayout(
                    visible = visibleDrawer,
                    currentRoute = currentRoute,
                    onChangeRoute = navController::navigate,
                    onDismissRequest = { visibleDrawer = false }
                )
            }
        }
    }
}

@Composable
private fun Header(logoContent: @Composable () -> Unit, menuContent: @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 120.dp.toResponsive(20.dp))
            .padding(top = 48.dp.toResponsive(30.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        logoContent()
        menuContent()
    }
}

@Composable
private fun Logo(onClick: () -> Unit) {
    Image(
        painter = painterResource(Res.drawable.logo_gdg_web),
        contentDescription = "GDG Logo",
        modifier = Modifier.size(width = 122.dp.toResponsive(100.dp), height = 50.dp.toResponsive(40.dp))
            .onClick(onClick = onClick)
    )
}