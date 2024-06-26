package presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.theme.GoogleBlue
import presentation.theme.GooglePurple
import presentation.theme.GoogleRed
import presentation.theme.White

@Composable
fun GradientButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    val colors = listOf(GoogleBlue, GooglePurple, GoogleRed)
    val gradient = Brush.horizontalGradient(colors)

    Button(
        onClick = onClick,
        modifier = modifier.background(brush = gradient, shape = RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 45.dp, vertical = 18.dp)
    ) {
        Text(text = text, color = White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}