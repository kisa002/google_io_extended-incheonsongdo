package presentation.support

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.produceState
import androidx.compose.ui.unit.IntSize
import kotlinx.browser.window
import org.w3c.dom.events.Event

object LocalBrowserSizeManager {
    val LocalBrowserSize = compositionLocalOf {
        getBrowserSize()
    }

    @Composable
    fun browserSizeAsState(): State<IntSize> {
        val browserWidth = produceState(getBrowserSize()) {
            val resizeEventListener: (Event) -> Unit = {
                value = getBrowserSize()
            }
            window.addEventListener(type = "resize", callback = resizeEventListener)
            awaitDispose {
                window.removeEventListener(type = "resize", callback = resizeEventListener)
            }
        }

        return browserWidth
    }
}