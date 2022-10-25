package com.ruthvikbr.starbucksindiacompose.ui.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.components.SpacerComponent
import com.ruthvikbr.starbucksindiacompose.ui.utils.rememberCoilImageRequest
import com.starbuckscompose.navigation.ComposeNavigator
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun NewsScreen(
    composeNavigator: ComposeNavigator,
    title: String?,
    imageUrl: String?,
    content: String?
) {

    val state = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
            )
            AsyncImage(
                model = rememberCoilImageRequest(data = imageUrl),
                contentDescription = title ?: "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .pin()
                    .padding(16.dp)
                    .clickable {
                        composeNavigator.navigateUp()
                    }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = title ?: "",
                    color = Color.Black,
                    style = MaterialTheme.typography.h4
                )
            }
            item {
                SpacerComponent(spaceInDp = 16.dp)
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        modifier = Modifier.size(50.dp), contentDescription = ""
                    )
                    SpacerComponent(spaceInDp = 16.dp, isVerticalSpace = false)
                    Text(
                        text = stringResource(id = R.string.starbucks_blog),
                        color = Color.Black.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.subtitle1.copy(fontSize = 16.sp)
                    )
                }
            }
            item {
                SpacerComponent(spaceInDp = 16.dp)
            }
            item {
                Text(
                    text = content ?: "",
                    color = Color.Black.copy(alpha = 0.5f),
                    style = MaterialTheme.typography.subtitle1.copy(fontSize = 14.sp)
                )
            }
        }
    }
}