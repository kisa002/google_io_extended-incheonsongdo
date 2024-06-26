package presentation.support

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

@Composable
fun Modifier.mobileThen(modifier: Modifier) = composed {
    if (isMobileScreen()) {
        then(modifier)
    } else {
        this
    }
}