package presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import google_io_extended_incheonsongdo.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font

@Stable
@Composable
fun PretendardFontFamily() = FontFamily(
    Font(resource = Res.font.Pretendard_Thin, weight = FontWeight.Thin),
    Font(resource = Res.font.Pretendard_ExtraLight, weight = FontWeight.ExtraLight),
    Font(resource = Res.font.Pretendard_Light, weight = FontWeight.Light),
    Font(resource = Res.font.Pretendard_Regular, weight = FontWeight.Normal),
    Font(resource = Res.font.Pretendard_Medium, weight = FontWeight.Medium),
    Font(resource = Res.font.Pretendard_SemiBold, weight = FontWeight.SemiBold),
    Font(resource = Res.font.Pretendard_Bold, weight = FontWeight.Bold),
    Font(resource = Res.font.Pretendard_ExtraBold, weight = FontWeight.ExtraBold),
    Font(resource = Res.font.Pretendard_Black, weight = FontWeight.Black),
)