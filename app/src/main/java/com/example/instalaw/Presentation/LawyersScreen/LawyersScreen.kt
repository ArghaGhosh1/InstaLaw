package com.example.instalaw.Presentation.LawyersScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.instalaw.R
import com.example.whatsappclone.presentation.homeScreen.bottomNavigation


@Composable
fun LawyersScreen(navController : NavHostController) {

    var lawyerList = listOf(

        LawyerSectionModel(
            R.drawable.lawyer_1,
            "Narendra Damodardas Modi",
            "Civil Lawyer",
            "Helping startups navigate complex regulatory frameworks and series funding rounds with ...",
            "Vadnagar,Gujarat"
        ),

        LawyerSectionModel(
            R.drawable.lawyer_2,
            "Mukul Rohatgi",
            "Criminal Lawyer",
            "Specializing in patent litigation and brand protection for high-growth technology companies ...",
            "Vadnagar,Gujarat"
        ),

        LawyerSectionModel(
            R.drawable.lawyer_3,
            "Harish Salve",
            "Family Lawyer",
            "Compassionate legal guidance for family disputes, mediation, and civil litigation needs.",
            "Vadnagar,Gujarat"
        ),

        LawyerSectionModel(
            R.drawable.lawyer_4,
            "Abhishek Manu Singhvi",
            "Corporate Lawyer",
            "Streamlining property transactions and commercial lease negotiations with digital efficiency...",
            "Vadnagar,Gujarat"
        ),

    )

    var searchLawyer by remember() {

        mutableStateOf("")
    }

    var isSelected by remember() {
        mutableStateOf(false)
    }

    Scaffold(

        bottomBar = {
            bottomNavigation(navController = navController)
        }


    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = colorResource(R.color.screen_background))
        ) {

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "InstaLaw",
                    color = colorResource(R.color.AppNameColor),
                    fontWeight = FontWeight.Bold, fontSize = 32.sp,
                )

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    "Find Verified Counsel",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(

                    value = searchLawyer,
                    onValueChange = { searchLawyer = it },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp),
                        )
                    },
                    placeholder = { Text("Search by name or keyword...") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)

                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.fillMaxWidth()) {

                    FilterDesign(
                        modifier = Modifier.weight(1f),
                        filterModel = FilterModel("All Locations", R.drawable.location)
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    FilterDesign(
                        modifier = Modifier.weight(1f),
                        filterModel = FilterModel("All Specialities", R.drawable.employee)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row() {
                    FilterChipDesign(filterChipModel = FilterChipModel("Top Rated"))

                    Spacer(modifier = Modifier.width(10.dp))
                    FilterChipDesign(filterChipModel = FilterChipModel("Available Today"))

                    Spacer(modifier = Modifier.width(10.dp))

                    FilterChipDesign(filterChipModel = FilterChipModel("Verified Only"))

                }

                Spacer(modifier = Modifier.height(20.dp))


                LazyColumn{

                    items(lawyerList){
                        LawyerSectionDesign(lawyerSectionModel = it)

                    }

                }

            }
        }


    }

}