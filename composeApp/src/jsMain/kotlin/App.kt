@file:OptIn(ExperimentalFoundationApi::class)

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import google_io_extended_incheonsongdo.composeapp.generated.resources.Res
import google_io_extended_incheonsongdo.composeapp.generated.resources.logo_gdg_web
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun App() {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize().background(Color.White).verticalScroll(state = rememberScrollState())) {
            Header(
                logoContent = { Logo() },
                menuContent = {
                    Menu(text = "HOME", selected = true) {
                        // TODO
                    }
                    Menu(text = "ABOUT", selected = false) {
                        // TODO
                    }
                    Menu(text = "SESSIONS", selected = false) {
                        // TODO
                    }
                }
            )
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
        contentDescription = "Logo",
        modifier = Modifier.size(width = 122.dp, height = 50.dp)
    )
}

@Composable
private fun Menu(text: String, selected: Boolean, onClick: () -> Unit) {
    val color = if (selected) Color(0xFF374151) else Color(0xFF4B5563)

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