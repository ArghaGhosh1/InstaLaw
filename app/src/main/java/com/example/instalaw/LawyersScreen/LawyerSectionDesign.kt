package com.example.instalaw.LawyersScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalaw.R

@Composable
fun LawyerSectionDesign(
    lawyerSectionModel: LawyerSectionModel
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = null

    ) {


        Image(
            painter = painterResource(lawyerSectionModel.lawyerImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )


        Column(modifier = Modifier.padding(30.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    lawyerSectionModel.lawyerName,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.lawyers_card_Name_color)
                )

                Icon(
                    painter = painterResource(R.drawable.verified),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Blue
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                lawyerSectionModel.lawyerType,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.lawyers_card_specialization_color)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                lawyerSectionModel.lawyerDesc,
                fontSize = 15.sp,
                color = colorResource(R.color.lawyers_card_desc_color)
            )

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.location),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = colorResource(R.color.lawyers_card_locationIcon_color)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    lawyerSectionModel.lawyerLoc,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.lawyers_card_location_color)
                )

                Spacer(modifier = Modifier.width(10.dp))
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.lawyers_card_Button_color)
                )
            ) {

                Text(
                    "Book Consultation",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }

    }

    Spacer(modifier = Modifier.height(30.dp))
}