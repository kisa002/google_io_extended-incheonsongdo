package presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.support.toResponsive

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp, bottom = 178.dp.toResponsive(98.dp))
            .padding(horizontal = 0.dp.toResponsive(20.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RsvpSection()
        InfoSection(modifier = Modifier.padding(top = 200.dp.toResponsive(120.dp)))
    }
}