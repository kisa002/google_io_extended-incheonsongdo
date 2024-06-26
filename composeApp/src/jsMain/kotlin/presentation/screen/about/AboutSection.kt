package presentation.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.support.isMobileScreen
import presentation.support.toResponsive
import presentation.theme.Gray600

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFEFBFA))
            .padding(vertical = 32.dp.toResponsive(50.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "About Google I/O Extended 2024",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                    append("GDG 인천/송도에서 Google I/O Extended 2024")
                }
                appendLine(
                    """
                        에서는
                        5월 진행된 Google I/O에서 다뤘던 내용과 함께,
                        """.trimIndent()
                )
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                    if (isMobileScreen())
                        appendLine("다양한 Tech 세션과\nGeneral 세션이 준비되어 있습니다.\n")
                    else
                        appendLine("다양한 Tech 세션과 General 세션이 준비되어 있습니다.\n")
                }
                if (isMobileScreen())
                    append("폭넓은 지식을 쌓고, 더 알아보고,\n고민을 나누고, 네트워킹하는 시간이 되시길 바랍니다.")
                else
                    append("폭넓은 지식을 쌓고, 더 알아보고, 고민을 나누고, 네트워킹하는 시간이 되시길 바랍니다.")
            },
            modifier = Modifier.padding(top = 24.dp),
            color = Gray600,
            fontSize = 18.sp.toResponsive(16.sp),
            textAlign = TextAlign.Center
        )
    }
}