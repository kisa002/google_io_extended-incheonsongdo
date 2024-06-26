package presentation.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.theme.Gray500
import presentation.theme.Gray700

@Composable
fun InfoSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(horizontalArrangement = Arrangement.spacedBy(190.dp)) {
            InfoItem(
                key = "일시/장소",
                value1 = "2024.07.27.(토)",
                value2 = "송도 컨벤시아"
            )
            InfoItem(
                key = "세션 수",
                value = "25+"
            )
            InfoItem(
                key = "인원",
                value = "800명"
            )
        }
    }
}

@Composable
private fun InfoItem(key: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = key, color = Gray500, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        Text(
            text = value,
            modifier = Modifier.padding(top = 16.dp),
            color = Gray700,
            fontSize = 64.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun InfoItem(key: String, value1: String, value2: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = key, color = Gray500, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        CompositionLocalProvider(
            LocalTextStyle provides LocalTextStyle.current.copy(
                color = Gray700,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            Text(
                text = value1,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = value2,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}