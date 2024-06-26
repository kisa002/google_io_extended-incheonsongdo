package presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import google_io_extended_incheonsongdo.composeapp.generated.resources.Res
import google_io_extended_incheonsongdo.composeapp.generated.resources.gdg_main_item
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import presentation.component.GradientButton
import presentation.support.ResponsiveContent
import presentation.support.toResponsive
import presentation.theme.Gray800

@Composable
fun RsvpSection() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(Res.drawable.gdg_main_item), contentDescription = "GDG Event Logo")
        Text(
            text = "GDG Incheon/Songdo",
            modifier = Modifier.padding(top = 42.dp),
            color = Gray800,
            fontSize = 32.sp.toResponsive(24.sp),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "IOEX '24",
            modifier = Modifier.padding(top = 16.dp),
            color = Gray800,
            fontSize = 64.sp.toResponsive(48.sp),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        ResponsiveContent(
            desktopContent = {
                Text(
                    text = buildAnnotatedString {
                        append(
                            """
                            GDG 인천/송도에서 Google I/O Extended를 개최합니다.
                            5월 진행된 Google I/O 내용은 물론, 다양한 Tech 세션이 포함되며
                            IT 업무, 자기계발, 성장 등
                            """.trimIndent()
                        )
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append(" 폭넓은 주제의 General 세션")
                        }
                        append("을 준비하고 있으니 많은 참여 부탁드려요!")
                    },
                    modifier = Modifier.padding(top = 24.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            },
            mobileContent = {
                Text(
                    text = buildAnnotatedString {
                        appendLine(
                            """
                        GDG 인천/송도에서 
                        Google I/O Extended를 개최합니다.
                        5월 진행된 Google I/O 내용은 물론,
                        다양한 Tech 세션이 포함되며
                        IT 업무, 자기계발, 성장 등 
                    """.trimIndent()
                        )
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(" 폭넓은 주제의 General 세션")
                        }
                        append("을 준비하고 있으니\n많은 참여 부탁드려요!")
                    },
                    modifier = Modifier.padding(top = 16.dp),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            }
        )

        GradientButton(
            text = "RSVP NOW",
            modifier = Modifier.padding(top = 24.dp),
            onClick = {
                window.open("https://festa.io/events/5477")
            }
        )
    }
}