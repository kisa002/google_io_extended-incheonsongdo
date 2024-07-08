package presentation.component

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.navigation.NavRoutes
import presentation.theme.Gray600
import presentation.theme.Gray700
import presentation.theme.White

@Composable
fun DrawerLayout(
    visible: Boolean,
    currentRoute: String,
    onChangeRoute: (String) -> Unit,
    onDismissRequest: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
        AnimatedVisibility(visible = visible, enter = fadeIn(), exit = fadeOut()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF111111).copy(alpha = 0.7f))
                    .pointerInput(Unit) { detectTapGestures { onDismissRequest() } }
            )
        }
        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally(initialOffsetX = { it }),
            exit = slideOutHorizontally(targetOffsetX = { it })
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .background(color = White, shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .padding(horizontal = 20.dp, vertical = 32.dp),
            ) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "GDG Incheon / Songdo", color = Gray600, fontSize = 14.sp)
                    Text(
                        text = "Google I/O Extended 2024",
                        color = Gray700,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(50.dp))

                Column(verticalArrangement = Arrangement.spacedBy(28.dp)) {
                    MenuItem(text = "HOME", selected = currentRoute == NavRoutes.Home.route) {
                        onDismissRequest()
                        onChangeRoute(NavRoutes.Home.route)
                    }
                    MenuItem(text = "ABOUT", selected = currentRoute == NavRoutes.About.route) {
                        onDismissRequest()
                        onChangeRoute(NavRoutes.About.route)
                    }
                }
            }
        }
    }
}