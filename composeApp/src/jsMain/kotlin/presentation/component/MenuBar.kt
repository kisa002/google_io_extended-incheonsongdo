package presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.theme.Gray700

@Composable
fun MenuBar(onClick: () -> Unit) {
    Column(modifier = Modifier.clickable(onClick = onClick)) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            repeat(3) {
                Box(modifier = Modifier.size(24.dp, height = 3.dp).background(Gray700))
            }
        }
        Text(text = "MENU", modifier = Modifier.padding(top = 6.dp), color = Gray700, fontSize = 8.sp)
    }
}