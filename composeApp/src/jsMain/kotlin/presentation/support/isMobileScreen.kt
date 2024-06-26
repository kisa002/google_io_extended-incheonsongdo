package presentation.support

import androidx.compose.runtime.*

@Composable
fun isMobileScreen(): Boolean {
    val browser = LocalBrowserSizeManager.LocalBrowserSize.current

    return browser.width <= 768
}