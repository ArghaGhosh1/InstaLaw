package com.example.instalaw.Presentation.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.instalaw.R
import com.example.whatsappclone.presentation.homeScreen.bottomNavigation

@Composable
fun HomeScreen(navController : NavHostController,
               aiViewModel: AIViewModel = viewModel()) {
    var legalQuestion by remember() {

        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.background(colorResource(R.color.screen_background)),


        bottomBar = {

            bottomNavigation(navController = navController)
        }


    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .background(color = colorResource(R.color.screen_background))
        )
        {


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    "InstaLaw",
                    color = colorResource(R.color.AppNameColor),
                    fontWeight = FontWeight.Bold, fontSize = 30.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )


                Icon(
                    painter = painterResource(R.drawable.outline_add_alert_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .clickable { },
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {

                Text(
                    "Instant Legal Clarity.",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Ask your legal question and get precise, AI-",
                    fontSize = 16.sp, color = Color.DarkGray
                )


                Spacer(modifier = Modifier.height(2.5.dp))

                Text(
                    "powered guidance within seconds.",
                    fontSize = 16.sp, color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    OutlinedTextField(
                        value = legalQuestion,
                        onValueChange = { legalQuestion = it },
                        modifier = Modifier.weight(0.72f),
                        placeholder = {
                            Text("Ask a legal question...")
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.search),
                                contentDescription = null,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        shape = RoundedCornerShape(15.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            aiViewModel.askQuestion(legalQuestion)
                        },
                        enabled = legalQuestion.isNotBlank() && !aiViewModel.isLoading,
                        modifier = Modifier
                            .height(56.dp)
                            .weight(0.28f),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.Button_Blue)
                        )
                    ) {
                        Text(
                            if (aiViewModel.isLoading)
                                "Thinking..."
                            else
                                "Ask Now"
                        )
                    }
                }

                if (aiViewModel.isLoading) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "InstaLaw AI is thinking...",
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    )
                }

                if (aiViewModel.errorMessage.isNotEmpty()) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = aiViewModel.errorMessage,
                        color = Color.Red,
                        fontSize = 14.sp
                    )
                }

                if (aiViewModel.answer.isNotEmpty()) {

                    Spacer(modifier = Modifier.height(24.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(18.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(
                                text = "InstaLaw AI",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = aiViewModel.answer,
                                fontSize = 16.sp,
                                lineHeight = 25.sp,
                                color = Color.DarkGray
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth())
                {
                    Text(
                        "Quick Actions",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(15.dp))


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        QuickActionsDesign(
                            modifier = Modifier.weight(1f),
                            QuickActionModel = QuickActionsModel(
                                R.drawable.traffic,
                                "Traffic"
                            )
                        )

                        QuickActionsDesign(
                            modifier = Modifier.weight(1f),
                            QuickActionModel = QuickActionsModel(
                                R.drawable.employee,
                                "Employment"
                            )
                        )

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        QuickActionsDesign(
                            modifier = Modifier.weight(1f),
                            QuickActionModel = QuickActionsModel(
                                R.drawable.building,
                                "Rent"
                            )
                        )

                        QuickActionsDesign(
                            modifier = Modifier.weight(1f),
                            QuickActionModel = QuickActionsModel(
                                R.drawable.family,
                                "Family"
                            )
                        )

                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        "Recent Suggestions",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    RecentSuggestionsDesign(
                        RecentSuggetionModel = RecentSuggestionsModel(
                            "2 hours ago",
                            "Housing",
                            "Unfair Security Deposit Deduction",
                            "Based on New York State law, your landlord must provide an itemized statement within 14 days of vacancy..."
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    RecentSuggestionsDesign(
                        RecentSuggetionModel = RecentSuggestionsModel(
                            "Yesterday",
                            "Employment",
                            "Overtime Exemption Status",
                            "Your role as a 'Senior Designer' may still qualify for overtime pay if your salary falls below the 2024 threshold of..."
                        )
                    )

                }

                Spacer(modifier = Modifier.height(30.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 3.dp
                    )
                ) {

                    Box() {
                        Image(
                            painter = painterResource(R.drawable.law_office),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Black.copy(alpha = 0.55f),
                                            Color.Black.copy(alpha = 0.35f)
                                        )
                                    )
                                )
                        )

                        Column(
                            modifier = Modifier
                                .align(alignment = Alignment.BottomStart)
                                .padding(
                                    start = 24.dp,
                                    end = 24.dp,
                                    bottom = 26.dp
                                )
                        ){

                            Text(
                                text = "Professional Grade\nAnalysis",
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                lineHeight = 40.sp
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "Our AI is trained on over 50,000 precedents and legislative acts to ensure your answers are legally sound.",
                                fontSize = 18.sp,
                                color = Color.White.copy(alpha = 0.75f),
                                lineHeight = 26.sp
                            )

                        }

                    }


                }

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.end_card_color)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    )
                ){

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "98.4%",
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "ACCURACY RATING",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp,
                            color = Color.White.copy(alpha = 0.7f)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .height(3.dp)
                                .clip(RoundedCornerShape(50.dp))
                                .background(Color.White.copy(alpha = 0.25f))
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "\"Saved me \$4,000 in legal fees in under 5 minutes.\"",
                            fontSize = 22.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }


                }


            }
        }
    }


}