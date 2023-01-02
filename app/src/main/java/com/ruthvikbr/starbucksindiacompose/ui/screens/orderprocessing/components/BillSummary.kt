package com.ruthvikbr.starbucksindiacompose.ui.screens.orderprocessing.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruthvikbr.starbucksindiacompose.R
import com.ruthvikbr.starbucksindiacompose.ui.theme.PrimaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.theme.SecondaryWhite
import com.ruthvikbr.starbucksindiacompose.ui.utils.BillSummary

@Composable
fun OrderBillSummary(billSummary: BillSummary) {
    Column(
        modifier = Modifier
            .background(SecondaryWhite)
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(PrimaryWhite)
            .padding(16.dp)
    ) {
        BillSummaryItem(value = billSummary.cartTotal, label = stringResource(id = R.string.bill_summary_subtotal))
        BillSummaryItem(value = billSummary.tax, label = stringResource(id = R.string.bill_summary_others))
        BillSummaryItem(
            value = billSummary.grandTotal,
            label = stringResource(id = R.string.bill_summary_grand_total),
            labelStyle = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            ),
            valueStyle = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        )
    }
}

@Composable
fun BillSummaryItem(
    value: Int,
    label: String,
    labelStyle: TextStyle = MaterialTheme.typography.subtitle1,
    valueStyle: TextStyle = MaterialTheme.typography.subtitle1
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = labelStyle)
        Text(
            text = stringResource(id = R.string.currency_symbol, value),
            style = valueStyle
        )
    }
}
