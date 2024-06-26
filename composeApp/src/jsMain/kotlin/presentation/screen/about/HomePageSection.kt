package presentation.screen.about

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import google_io_extended_incheonsongdo.composeapp.generated.resources.Res
import google_io_extended_incheonsongdo.composeapp.generated.resources.gdg_logo
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import presentation.theme.Black
import presentation.theme.GoogleBlue
import presentation.theme.Gray400

@Composable
fun HomePageSection() {
    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFF34A853),
            Color(0xFF4285F4),
            Color(0xFF9F6CD4),
            Color(0xFFDE494E),
            Color(0xFFEA4335),
            Color(0xFFF46831),
            Color(0xFFFFCB32),
        )
    )

    Text(
        text = "Developers Coding For A Better World !",
        style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, brush = gradient)
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(32.dp)) {
        CompositionLocalProvider(
            LocalTextStyle provides LocalTextStyle.current.copy(
                color = Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("GDG(Google Developer Groups)")
                    }
                    appendLine("란")
                    appendLine(
                        """
                        Google의 기술을 바탕으로 자율적으로 활동하는 개발자 커뮤니티입니다.
                        현재 140개 국가에서 1, 000개 이상의 챕터가 활동하고 있습니다.
                        국내에서는 GDG 서울, 판교, 인천, 송도, 대전, 부산, 제주 챕터가 존재합니다.
                    """.trimIndent()
                    )
                    appendLine()
                    appendLine(
                        """
                            GDG 인천/송도는 각각 인천과 송도 지역을 중심으로 활동하는 GDG 챕터입니다.
                                현재까지 Google I/O Extended, DevFest, Build with AI 등의 다양한 행사를 주최하고 있으며,
                                오픈소스 스터디를 지속적으로 진행하고 있습니다.
                                
                                흥미진진한 프로젝트를 만들고, 열정으로 IT 기술에 대한 경험을 공유하며,
                                IT 생태계의 발전 및 개발자의 학습과 네트워킹을 촉진하는 것이 목표입니다.
                        """.trimIndent()
                    )
                },
                modifier = Modifier.padding(top = 40.dp)
            )
            Text(
                text = "면책 조항: GDG 인천/송도는 독립적으로 운영되는 커뮤니티로, GDG 인천/송도의 활동 및 입장은 Google과 무관합니다.",
                color = Gray400,
                fontSize = 14.sp
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            HomePageButton(text = "인천") {
                window.open("https://gdg.community.dev/gdg-incheon/")
            }
            HomePageButton(text = "송도") {
                window.open("https://gdg.community.dev/gdg-songdo/")
            }
        }
    }
}

@Composable
private fun HomePageButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(100),
        border = BorderStroke(width = 1.dp, color = Black),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFFEFBFA)
        ),
        contentPadding = PaddingValues(20.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(Res.drawable.gdg_logo),
                contentDescription = "GDG Logo",
            )
            Text(
                text = buildAnnotatedString {
                    append("GDG ")
                    withStyle(style = SpanStyle(color = GoogleBlue)) {
                        append(text)
                    }
                    append(" 홈페이지 바로가기")
                },
                color = Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}