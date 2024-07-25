@file:OptIn(ExperimentalLayoutApi::class)

package presentation.screen.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import data.Session
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.core.*
import presentation.component.TagChip
import presentation.support.ResponsiveContent
import presentation.support.chooseResponsive
import presentation.support.toResponsive
import presentation.theme.Gray500
import presentation.theme.Gray700

@Composable
fun SessionsSection(modifier: Modifier = Modifier, onShowSessionDetail: (Session) -> Unit) {
    val sessions by produceState(emptyList()) {
        value = HttpClient().use { client ->
            client
                .get("https://haeyum.dev/gdg/io-extended/api/timetable.csv")
                .bodyAsText()
                .split("\n")
                .drop(1)
                .map { it.split("|") }
                .map {
                    Session(
                        speaker = it[0],
                        room = it[1],
                        begin = it[2],
                        end = it[3],
                        track = it[4],
                        title = it[5],
                        etc = it[6],
                        career = it[7],
                        image = it[8]
                    )
                }
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SESSIONS", color = Gray700, fontSize = 36.sp, fontWeight = FontWeight.SemiBold)
        ResponsiveSessionsRow(
            sessions = sessions,
            modifier = Modifier.padding(top = 40.dp.toResponsive(30.dp)),
            onShowSessionDetail = onShowSessionDetail
        )
    }
}

@Composable
private fun ResponsiveSessionsRow(
    sessions: List<Session>,
    modifier: Modifier = Modifier,
    onShowSessionDetail: (Session) -> Unit
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp.toResponsive(8.dp)),
        verticalArrangement = Arrangement.spacedBy(24.dp.toResponsive(16.dp)),
        maxItemsInEachRow = chooseResponsive(
            desktop = Int.MAX_VALUE,
            mobile = 2
        )
    ) {
        sessions.forEach { session ->
            SessionItem(
                session = session,
                modifier = chooseResponsive(
                    desktop = Modifier.width(240.dp),
                    mobile = Modifier.weight(1f)
                ),
                onClick = onShowSessionDetail
            )
        }
    }
}

@Composable
private fun SessionItem(session: Session, modifier: Modifier = Modifier, onClick: (Session) -> Unit) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick(session) }
            .padding(8.dp)
    ) {
        AsyncImage(
            model = session.image,
            contentDescription = "Speaker Profile Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(1.dp, Gray500, RoundedCornerShape(12.dp)),
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = session.title,
            modifier = Modifier.padding(top = 24.dp),
            color = Gray700,
            fontSize = 20.sp.toResponsive(18.sp),
            fontWeight = FontWeight.SemiBold
        )
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp.toResponsive(4.dp))
        ) {
            TagChip(text = session.room)
            TagChip(text = session.track)
        }
    }
}