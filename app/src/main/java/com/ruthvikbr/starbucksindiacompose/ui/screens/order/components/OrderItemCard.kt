package com.ruthvikbr.starbucksindiacompose.ui.screens.order.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ruthvikbr.domain.models.DMOrderItem
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.AccentGreen
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.SecondaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.rememberCoilImageRequest

@Composable
fun OrderItemCard(dmOrderItem: DMOrderItem) {
    Row(
        modifier = Modifier.fillMaxWidth().height(100.dp).clip(RoundedCornerShape(12.dp))
            .background(
                PrimaryWhite
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = rememberCoilImageRequest(data = dmOrderItem.itemImageUrl),
                contentDescription = dmOrderItem.itemName,
                modifier = Modifier.size(100.dp).background(SecondaryWhite),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier.height(100.dp).padding(start = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = dmOrderItem.itemName,
                    style = MaterialTheme.typography.h5,
                    color = AccentGreen
                )
                Text(
                    text = "$ ${dmOrderItem.itemPrice}",
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
        Counter(productCount = dmOrderItem.itemCount, updateProductCount = {})
    }
}

@Composable
fun Counter(updateProductCount: (Int) -> Unit, productCount: Int) {
    Row(
        modifier = Modifier.height(30.dp).padding(end = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_decrease),
            contentDescription = "",
            tint = PrimaryWhite,
            modifier = Modifier.size(24.dp).background(AccentGreen).clickable {}
        )
        Text(
            text = productCount.toString(),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.size(24.dp),
            textAlign = TextAlign.Center
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "",
            tint = PrimaryWhite,
            modifier = Modifier.size(24.dp).background(AccentGreen).clickable {}
        )
    }
}
