package presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.support.toResponsive
import presentation.theme.Gray500

@Composable
fun TagChip(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .border(width = 1.dp, color = Gray500, shape = RoundedCornerShape(100.dp))
            .padding(horizontal = 12.dp.toResponsive(6.dp), vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = Gray500, fontSize = 14.sp, fontWeight = FontWeight.Medium, lineHeight = 20.sp)
    }
}