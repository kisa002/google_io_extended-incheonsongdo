package presentation.screen.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.support.toResponsive

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp.toResponsive(60.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomePageSection(modifier = Modifier.fillMaxWidth().padding(horizontal = 0.dp.toResponsive(20.dp)))
        AboutSection(modifier = Modifier.fillMaxWidth().padding(top = 80.dp.toResponsive(120.dp)))
    }
}