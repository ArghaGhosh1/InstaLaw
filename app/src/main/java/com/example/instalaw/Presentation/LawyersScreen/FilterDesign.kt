package com.example.instalaw.Presentation.LawyersScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalaw.R

@Composable

fun FilterDesign(
    modifier : Modifier = Modifier,
    filterModel: FilterModel
) {

    OutlinedCard(
        modifier = modifier
            .height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(
            1.dp,
            color = colorResource(R.color.lawyers_card_color)
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(filterModel.icon),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    filterModel.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    painter = painterResource(R.drawable.arrow_down),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                )
            }
        }
    }
}