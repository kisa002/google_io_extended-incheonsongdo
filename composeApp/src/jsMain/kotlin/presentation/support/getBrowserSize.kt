package presentation.support

import androidx.compose.ui.unit.IntSize
import kotlinx.browser.window

fun getBrowserSize(): IntSize = IntSize(window.innerWidth, window.outerHeight)