package com.ruthvikbr.starbucksindiacompose.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryBlack

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StarbucksTextField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    label: String,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.subtitle1,
            color = PrimaryBlack,
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .drawBehind {
                    val borderWidth = 1.dp.toPx()
                    val y = size.height - borderWidth / 2
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = borderWidth,
                    )
                },
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            decorationBox = @Composable {
                TextFieldDefaults.TextFieldDecorationBox(
                    value = value,
                    innerTextField = it,
                    enabled = true,
                    singleLine = true,
                    trailingIcon = trailingIcon,
                    visualTransformation = visualTransformation,
                    interactionSource = MutableInteractionSource(),
                    contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                        0.dp,
                    ),
                    placeholder = {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.Light,
                            color = Color.DarkGray,
                        )
                    },
                )
            },
        )
    }
}
