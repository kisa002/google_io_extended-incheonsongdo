package presentation.support

import androidx.compose.runtime.Composable

@Composable
fun <T> chooseResponsive(desktop: T, mobile: T): T = if (isMobileScreen()) mobile else desktop