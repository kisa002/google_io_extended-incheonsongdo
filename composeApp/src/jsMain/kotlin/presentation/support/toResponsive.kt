package presentation.support

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun Dp.toResponsive(mobileSize: Dp) = if (isMobileScreen())
    mobileSize
else
    this

@Composable
fun TextUnit.toResponsive(mobileSize: TextUnit) = if (isMobileScreen())
    mobileSize
else
    this