package presentation.support

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ResponsiveContent(
    modifier: Modifier = Modifier,
    desktopContent: @Composable () -> Unit,
    mobileContent: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        if (isMobileScreen()) {
            mobileContent()
        } else {
            desktopContent()
        }
    }
}