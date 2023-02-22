package com.ruthvikbr.starbucksindiacompose.ui.screens.signup.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import com.ruthvikbr.starbucksindiacompose.ui.theme.HouseGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.CHECK_MARK_ANIMATION_DURATION
import com.ruthvikbr.starbucksindiacompose.ui.utils.INNER_CIRCLE_ANIMATION_DURATION
import com.ruthvikbr.starbucksindiacompose.ui.utils.OUTER_CIRCLE_ANIMATION_DURATION
import com.ruthvikbr.starbucksindiacompose.ui.utils.OUTER_CIRCLE_SCALE_ANIMATION_DURATION
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RegistrationSuccess(onSuccess: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryWhite),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CheckMarkAnimation(onSuccess)
    }
}

@Composable
fun CheckMarkAnimation(onSuccess: () -> Unit) {
    val outerCircleRadius = 200f
    val innerCircleRadius = 200f

    val checkMarkStrokeWidth = remember {
        Animatable(0f)
    }

    val animateFloat = remember {
        Animatable(0f)
    }

    var outerCircleScale by remember { mutableStateOf(1f) }
    var innerCircleScale by remember { mutableStateOf(0f) }

    val lineOnePxFloat = remember { Animatable(90f) }
    val lineOnePyFloat = remember { Animatable(405f) }
    val lineTwoPxFloat = remember { Animatable(90f) }
    val lineTwoPyFloat = remember { Animatable(405f) }

    LaunchedEffect(key1 = Unit) {
        coroutineScope {
            launch {
                animateFloat.animateTo(
                    1f,
                    animationSpec = tween(durationMillis = OUTER_CIRCLE_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            delay(OUTER_CIRCLE_ANIMATION_DURATION.toLong())
            launch {
                animate(
                    1f,
                    0.85f,
                    animationSpec = tween(durationMillis = OUTER_CIRCLE_SCALE_ANIMATION_DURATION, easing = LinearEasing),
                ) { value: Float, _: Float ->
                    outerCircleScale = value
                }
            }
            delay(OUTER_CIRCLE_SCALE_ANIMATION_DURATION.toLong())
            launch {
                animate(
                    0.85f,
                    1f,
                    animationSpec = tween(durationMillis = OUTER_CIRCLE_SCALE_ANIMATION_DURATION, easing = LinearEasing),
                ) { value: Float, _: Float ->
                    outerCircleScale = value
                }
            }
            launch {
                animate(
                    0f,
                    1f,
                    animationSpec = tween(durationMillis = INNER_CIRCLE_ANIMATION_DURATION, easing = LinearEasing),
                ) { value: Float, _: Float ->
                    innerCircleScale = value
                }
            }
            delay(INNER_CIRCLE_ANIMATION_DURATION.toLong())
            launch {
                checkMarkStrokeWidth.animateTo(
                    16f,
                    animationSpec = tween(CHECK_MARK_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            launch {
                lineOnePxFloat.animateTo(
                    targetValue = 40f,
                    animationSpec = tween(CHECK_MARK_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            launch {
                lineOnePyFloat.animateTo(
                    targetValue = 455f,
                    animationSpec = tween(CHECK_MARK_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            launch {
                lineTwoPxFloat.animateTo(
                    targetValue = 40f,
                    animationSpec = tween(CHECK_MARK_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            launch {
                lineTwoPyFloat.animateTo(
                    targetValue = 455f,
                    animationSpec = tween(CHECK_MARK_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            delay(CHECK_MARK_ANIMATION_DURATION.toLong())
            launch {
                lineTwoPxFloat.animateTo(
                    targetValue = -75f,
                    animationSpec = tween(CHECK_MARK_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            launch {
                lineTwoPyFloat.animateTo(
                    targetValue = 345f,
                    animationSpec = tween(CHECK_MARK_ANIMATION_DURATION, easing = LinearEasing),
                )
            }
            delay(CHECK_MARK_ANIMATION_DURATION.toLong())
            launch {
                onSuccess()
            }
        }
    }
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                scaleX = outerCircleScale
                scaleY = outerCircleScale
            },
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.width

        drawArc(
            color = HouseGreen,
            startAngle = -90f,
            sweepAngle = 360f * animateFloat.value,
            useCenter = false,
            style = Stroke(16.0f),
            size = Size(
                outerCircleRadius * 2,
                outerCircleRadius * 2,
            ),
            topLeft = Offset(
                (canvasWidth / 2) - (outerCircleRadius),
                (canvasHeight / 2) + (outerCircleRadius),
            ),
        )
        drawCircle(
            color = HouseGreen,
            radius = innerCircleRadius * innerCircleScale,
            center = Offset(
                x = canvasWidth / 2,
                y = ((canvasHeight / 2) + (outerCircleRadius * 2)),
            ),
        )
        drawLine(
            color = PrimaryWhite,
            start = Offset(x = (canvasWidth / 2 - 90f), y = (canvasHeight / 2 + 405f)),
            end = Offset(
                x = ((canvasWidth / 2) - lineOnePxFloat.value),
                y = ((canvasHeight / 2) + lineOnePyFloat.value),
            ),
            strokeWidth = checkMarkStrokeWidth.value,
            cap = StrokeCap.Round,
        )
        drawLine(
            color = PrimaryWhite,
            start = Offset(
                x = ((canvasWidth / 2) - lineOnePxFloat.value),
                y = ((canvasHeight / 2) + lineOnePyFloat.value),
            ),
            end = Offset(
                x = ((canvasWidth / 2) - lineTwoPxFloat.value),
                y = ((canvasHeight / 2) + lineTwoPyFloat.value),
            ),
            strokeWidth = checkMarkStrokeWidth.value,
            cap = StrokeCap.Round,
        )
    }
}
