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
import presentation.support.ResponsiveContent
import presentation.theme.Gray500
import presentation.theme.Gray700

@Composable
fun InfoSection(modifier: Modifier = Modifier) {
    ResponsiveContent(
        modifier = modifier,
        desktopContent = {
            Row(modifier = Modifier.fillMaxWidth()) {
                InfoItems(modifier = Modifier.weight(1f))
            }
        },
        mobileContent = {
            Column(modifier = Modifier.fillMaxWidth()) {
                InfoItems(modifier = modifier.fillMaxWidth())
            }
        }
    )
}

@Composable
private fun InfoItems(modifier: Modifier = Modifier) {
    InfoItem(
        modifier = modifier,
        key = "일시/장소",
        value1 = "2024.07.27.(토)",
        value2 = "송도 컨벤시아"
    )

    InfoItem(
        modifier = modifier,
        key = "세션 수",
        value = "30+"
    )

    InfoItem(
        modifier = modifier,
        key = "인원",
        value = "800명"
    )
}

@Composable
private fun InfoItem(modifier: Modifier = Modifier, key: String, value: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
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
private fun InfoItem(modifier: Modifier = Modifier, key: String, value1: String, value2: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
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