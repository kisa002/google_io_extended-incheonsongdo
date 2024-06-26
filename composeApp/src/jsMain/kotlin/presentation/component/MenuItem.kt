package presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import presentation.support.toResponsive
import presentation.theme.Gray600
import presentation.theme.Gray700

@Composable
fun MenuItem(text: String, selected: Boolean, onClick: () -> Unit) {
    val color = if (selected) Gray700 else Gray600

    Column(modifier = Modifier.clickable(onClick = onClick)) {
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
            fontSize = 16.sp.toResponsive(20.sp),
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}