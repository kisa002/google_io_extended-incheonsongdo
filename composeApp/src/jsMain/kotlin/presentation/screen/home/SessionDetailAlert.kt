package presentation.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Session
import presentation.component.TagChip
import presentation.theme.Black
import presentation.theme.GoogleRed
import presentation.theme.Gray700
import presentation.theme.White

@Composable
fun SessionDetailAlert(selectedSession: Session?, onDismissRequest: () -> Unit) {
    AnimatedVisibility(visible = selectedSession != null, enter = fadeIn(), exit = fadeOut()) {
        selectedSession?.let { session ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF111111).copy(alpha = 0.7f))
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = { onDismissRequest() })
                    },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(White)
                        .border(width = 1.dp, color = Black, shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 30.dp)
                        .padding(top = 24.dp, bottom = 42.dp)
                ) {
                    IconButton(
                        onClick = onDismissRequest,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Icon(imageVector = Icons.Outlined.Close, contentDescription = "Close")
                    }
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        Row(
                            modifier = Modifier.clip(RoundedCornerShape(12.dp))
                                .border(width = 1.dp, color = Black, shape = RoundedCornerShape(12.dp))
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(width = 200.dp, height = 200.dp)
                                    .background(GoogleRed)
                            )
                            Column(modifier = Modifier.padding(20.dp)) {
                                Text(
                                    text = session.speaker,
                                    color = Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                CompositionLocalProvider(
                                    LocalTextStyle provides LocalTextStyle.current.copy(
                                        color = Gray700,
                                        fontSize = 14.sp
                                    )
                                ) {
                                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Text(text = session.career)
                                        Text(text = session.time)
                                        Text(text = session.room)
                                    }
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.padding(top = 24.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            TagChip(text = session.room)
                            TagChip(text = session.track)
                        }

                        Text(
                            text = session.title,
                            modifier = Modifier.padding(top = 8.dp),
                            color = Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}