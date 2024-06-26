package presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

@Composable
fun GdgTheme(content: @Composable () -> Unit) {
    val fontFamily = PretendardFontFamily()

    MaterialTheme(typography = Typography(defaultFontFamily = fontFamily), content = content)
}