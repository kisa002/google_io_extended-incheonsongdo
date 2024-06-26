@file:OptIn(ExperimentalLayoutApi::class)

package presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Session
import presentation.component.TagChip
import presentation.support.ResponsiveContent
import presentation.support.isMobileScreen
import presentation.support.toResponsive
import presentation.theme.GoogleRed
import presentation.theme.Gray500
import presentation.theme.Gray700

@Composable
fun SessionsSection(modifier: Modifier = Modifier, onShowSessionDetail: (Session) -> Unit) {
    val sessions = data.sessions

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SESSIONS", color = Gray700, fontSize = 36.sp, fontWeight = FontWeight.SemiBold)
        ResponsiveContent(
            modifier = Modifier.padding(top = 40.dp.toResponsive(30.dp)),
            desktopContent = {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(28.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    sessions.forEach { session ->
                        SessionItem(
                            session = session,
                            modifier = Modifier.width(360.dp),
                            onClick = onShowSessionDetail
                        )
                    }
                }
            },
            mobileContent = {
                FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp), maxItemsInEachRow = 2) {
                    sessions.forEach { session ->
                        SessionItem(
                            session = session,
                            modifier = Modifier.weight(1f),
                            onClick = onShowSessionDetail
                        )
                    }
                }
            }
        )
    }
}

@Composable
private fun SessionItem(session: Session, modifier: Modifier = Modifier, onClick: (Session) -> Unit) {
    // toResponsive(260.dp)
    Column(modifier = modifier.clip(RoundedCornerShape(12.dp)).clickable { onClick(session) }) {
        Box(modifier = Modifier.fillMaxWidth().height(140.dp).background(GoogleRed))
        Text(
            text = session.title,
            modifier = Modifier.padding(top = 24.dp),
            color = Gray700,
            fontSize = 24.sp.toResponsive(18.sp),
            fontWeight = FontWeight.SemiBold
        )
//        Text(
//            text = "세션에 대한 설명에 대한 내용이 필요한 것에 대한 이야기",
//            modifier = Modifier.padding(top = 12.dp),
//            color = Gray800,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.SemiBold
//        )
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp.toResponsive(4.dp))
        ) {
            TagChip(text = session.room)
            TagChip(text = session.track)
        }
    }
}