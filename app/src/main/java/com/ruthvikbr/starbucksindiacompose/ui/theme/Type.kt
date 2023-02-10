package com.ruthvikbr.starbucksindiacompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ruthvikbr.starbucksindiacompose.R

val SourceSansFontFamily = FontFamily(
    Font(R.font.source_sans_pro_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.source_sans_pro_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.source_sans_pro_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.source_sans_pro_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.source_sans_pro_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.source_sans_pro_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.source_sans_pro_semi_bold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(R.font.source_sans_pro_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(R.font.source_sans_pro_extra_light, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(R.font.source_sans_pro_extra_light_italic, weight = FontWeight.Thin, style = FontStyle.Italic),
)

val StarbucksTypography = Typography(
    body1 = TextStyle(
        fontFamily = SourceSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    h2 = TextStyle(
        fontFamily = SourceSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),
    h5 = TextStyle(
        fontFamily = SourceSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    ),
    h4 = TextStyle(
        fontFamily = SourceSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = SourceSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = SourceSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
)
