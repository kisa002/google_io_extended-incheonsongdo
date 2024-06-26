package presentation.support

import androidx.compose.runtime.*

@Composable
fun isMobileScreenAsState(): State<Boolean> {
    val browserWidth by browserWidthAsState()
    val isMobileScreen = remember(browserWidth) {
        browserWidth <= 768
    }

    return rememberUpdatedState(isMobileScreen)
}

@Composable
fun isMobileScreen(): Boolean {
    val browserWidth by browserWidthAsState()

    return browserWidth <= 768
}