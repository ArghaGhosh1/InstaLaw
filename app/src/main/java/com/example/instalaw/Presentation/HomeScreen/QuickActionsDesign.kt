package com.example.instalaw.Presentation.HomeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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

fun QuickActionsDesign(
    modifier : Modifier = Modifier,
    QuickActionModel : QuickActionsModel) {

    OutlinedCard(
        modifier = modifier
            .height(150.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(0.7.dp,
            color = colorResource(R.color.quickActionsColor)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.size(60.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE8F1FF)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(QuickActionModel.image),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xFF2563EB)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(QuickActionModel.type,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black)
        }
    }
}