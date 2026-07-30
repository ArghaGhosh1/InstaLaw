package com.example.instalaw.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalaw.R

@Composable

fun RecentSuggestionsDesign(RecentSuggetionModel: RecentSuggestionsModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )

    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)

        )
        {
            Row() {

                Icon(
                    painter = painterResource(R.drawable.time),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.Blue
                )

                Spacer(modifier = Modifier.width(5.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        RecentSuggetionModel.timing, //Here Here Here
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        RecentSuggetionModel.typeOfCase, //Here Here Here
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))



            Text(
                RecentSuggetionModel.caseHeading,  //Here here here
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                RecentSuggetionModel.caseDesc, // Here Here Here
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(20.dp))



                Row() {
                    Text(
                        "Read Full Summary",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Blue,
                        modifier = Modifier.clickable(){

                        }
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Icon(
                        painter = painterResource(R.drawable.outline_arrow_right_alt_24),
                        contentDescription = null,
                        modifier = Modifier,
                        tint = Color.Blue
                    )


                }


        }
    }
}