import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
//    onWasmReady {
//        CanvasBasedWindow("ComposeTarget") {
//            App()
//        }
//    }
    ComposeViewport(document.body!!) {
        MaterialTheme {
            Column(modifier = Modifier.fillMaxWidth().background(Color.Red)) {
                Text("WOW", modifier = Modifier.background(Color.Blue))
                Text("WOW", modifier = Modifier.background(Color.Yellow))
                Text("WOW", modifier = Modifier.background(Color.Cyan))
            }
        }
    }
}