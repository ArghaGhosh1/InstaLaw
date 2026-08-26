package com.example.instalaw.Presentation.All_Need_Tools

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationItem(
    icon: Int,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            ),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        // =============================================
        // SELECTED ICON BACKGROUND
        // =============================================

        Box(
            modifier = Modifier
                .size(
                    width = 48.dp,
                    height = 32.dp
                )
                .background(
                    color =
                        if (selected)
                            Color(0xFF007AFF)
                        else
                            Color.Transparent,

                    shape =
                        RoundedCornerShape(10.dp)
                ),

            contentAlignment =
                Alignment.Center
        ) {

            Icon(
                painter =
                    painterResource(icon),

                contentDescription =
                    label,

                modifier =
                    Modifier.size(20.dp),

                tint =
                    if (selected)
                        Color.White
                    else
                        Color.Gray
            )
        }


        Spacer(
            modifier =
                Modifier.height(2.dp)
        )


        // =============================================
        // LABEL
        // =============================================

        Text(
            text = label,

            fontSize = 9.sp,

            fontWeight =
                if (selected)
                    FontWeight.Bold
                else
                    FontWeight.Normal,

            color =
                if (selected)
                    Color(0xFF007AFF)
                else
                    Color.Gray
        )
    }
}