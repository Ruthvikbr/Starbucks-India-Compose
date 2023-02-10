package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing

import android.graphics.Paint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.CoffeeColor
import com.ruthvikbr.starbucksindiacompose.ui.theme.LightGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.starbuckscompose.navigation.ComposeNavigator
import com.starbuckscompose.navigation.StarbucksScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OrderProcessingScreen(composeNavigator: ComposeNavigator) {
    val coroutineScope = rememberCoroutineScope()

    var fillCup by rememberSaveable { mutableStateOf(false) }
    var orderStatusText by remember {
        mutableStateOf("Your order is being processed")
    }
    val pY by animateFloatAsState(
        targetValue = if (fillCup) 0.4f else 0.64f,
        animationSpec = tween(durationMillis = 2500),
        finishedListener = {
            coroutineScope.launch {
                orderStatusText = "Your order has been placed successfully"
                delay(500L)
                composeNavigator.navigate(StarbucksScreen.OrderSuccess.route)
            }
        },
    )
    val pxLeft by animateFloatAsState(
        targetValue = if (fillCup) 0.34f else 0.42f,
        animationSpec = tween(durationMillis = 2500),
    )
    val pxRight by animateFloatAsState(
        targetValue = if (fillCup) 0.66f else 0.58f,
        animationSpec = tween(durationMillis = 2500),
    )

    LaunchedEffect(key1 = true) {
        fillCup = true
    }

    val imageBitmap: ImageBitmap = ImageBitmap.imageResource(id = R.drawable.logo)
    val textColor = LocalContext.current.getColor(R.color.starbucks_green)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGreen),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val coffeeCupPath = Path().apply {
                this.moveTo(size.width * 0.30f, size.height * 0.35f)
                this.lineTo(size.width * 0.40f, size.height * 0.65f)
                this.lineTo(size.width * 0.60f, size.height * 0.65f)
                this.lineTo(size.width * 0.70f, size.height * 0.35f)
            }
            val coffeePath = Path().apply {
                this.moveTo(size.width * pxLeft, size.height * pY)
                this.lineTo(size.width * 0.42f, size.height * 0.64f)
                this.lineTo(size.width * 0.58f, size.height * 0.64f)
                this.lineTo(size.width * pxRight, size.height * pY)
            }
            drawPath(coffeeCupPath, color = PrimaryWhite)
            drawPath(coffeePath, color = CoffeeColor)
            drawImage(
                imageBitmap,
                dstSize = IntSize(100, 100),
                dstOffset = IntOffset(
                    (this.size.width / 2).toInt() - 50,
                    (this.size.height / 2).toInt() - 50,
                ),
            )
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    orderStatusText,
                    size.width / 2,
                    size.height * 0.75f,
                    Paint().apply {
                        textSize = 48f
                        color = textColor
                        textAlign = Paint.Align.CENTER
                    },
                )
            }
        }
    }
}
