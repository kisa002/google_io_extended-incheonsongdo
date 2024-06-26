package presentation.support

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import kotlinx.browser.window

@Composable
fun browserWidthAsState(): State<Int> {
    val browserWidth = produceState(window.innerWidth) {
        window.addEventListener(type = "resize", callback = {
            value = window.innerWidth
        })
    }

    return browserWidth
}