package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.LightGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.StarbucksGreen

@Composable
fun StepProgress(steps: Int, currentStep: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        for (i in 1..steps) {
            StepProgressIcon(label = i, isCompleted = i < currentStep, currentStep)
            if (i < steps) {
                StepProgressDivider(isCompleted = i < currentStep)
            }
        }
    }
}

@Composable
fun StepProgressIcon(label: Int, isCompleted: Boolean, currentStep: Int) {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(
                if (isCompleted && label != currentStep) {
                    HouseGreen
                } else {
                    PrimaryWhite
                },
            )
            .border(
                2.dp,
                if (isCompleted) {
                    HouseGreen
                } else if (label == currentStep) {
                    HouseGreen
                } else {
                    LightGreen
                },
                CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "$label",
            style = MaterialTheme.typography.subtitle1,
            color = if (isCompleted && label != currentStep) {
                PrimaryWhite
            } else if (label == currentStep) {
                HouseGreen
            } else {
                StarbucksGreen
            },
        )
    }
}

@Composable
fun StepProgressDivider(isCompleted: Boolean) {
    Divider(
        modifier = Modifier.width(125.dp).background(
            if (isCompleted) {
                HouseGreen
            } else {
                LightGreen
            },
        ),
    )
}
