package com.example.lputouch.ui.features.profile.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lputouch.ui.features.profile.profile_screen.components.profileTopBar.ProfileTopBar

import com.skydoves.flexible.bottomsheet.material.FlexibleBottomSheet
import com.skydoves.flexible.core.FlexibleSheetSize
import com.skydoves.flexible.core.FlexibleSheetValue
import com.skydoves.flexible.core.rememberFlexibleBottomSheetState
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lputouch.R
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.data.source.ProfileDetailsList
import com.example.lputouch.ui.components.LoadingOverlay.LoadingOverlay
import com.example.lputouch.ui.features.profile.profile_screen.components.ProfileDragHandler
import com.example.lputouch.ui.theme.Nunito
import kotlinx.coroutines.delay

data class FuckOff(
    val key: String,
    val value: String,
)

val drawerDetails: List<FuckOff> = listOf(
    FuckOff("Name:", "Deshmukh Bharat Vasanta"),
    FuckOff("Program:", "P132: B.Tech. (Computer Science and Engineering) (2024)"),
    FuckOff("Hostel:", "Boys Hostel-02- A606-Bed A (Std Non-AC 4 Seater)"),
)

@Composable
@ExperimentalMaterial3Api
fun ProfileScreen(navController: NavController) {
    var scope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }
    var sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )




    Scaffold(
        topBar = { ProfileTopBar(navController, sheetState, { showSheet = true }) }
    ) { paddingValues ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 8.dp)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
            ) {


                //prifile column
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFFFF8278),
                                    Color(0xFFFCCC6A)
                                )
                            )
                        )
                        .padding(vertical = 18.dp),
                    verticalArrangement = Arrangement.spacedBy(
                        2.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(R.drawable.me),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Text(
                        "Deshmukh Bharat Vasanta",
                        fontFamily = Nunito,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "P132:B.Tech. (Computer Science and Engineering)(2024)",
                        fontFamily = Nunito,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                }






                Spacer(modifier = Modifier.height(28.dp))


                //sections column
                Column(modifier = Modifier.fillMaxWidth()) {
                    ProfileDetailsList.getProfileDetails().forEach { section ->

                        //section box
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(38.dp)
                                    .background(Color(0xFF323232)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    section.sectionName,
                                    fontFamily = Nunito,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            section.detailList.forEach { sectionDot ->

                                //detialDot row
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White)
                                        .padding(horizontal = 18.dp)
                                ) {
                                    Text(
                                        sectionDot.name,
                                        fontFamily = Nunito,
                                        fontSize = 14.2.sp,
                                        fontWeight = FontWeight.Bold,
                                        lineHeight = 14.5.sp,
                                        color = Color(
                                            0xFF696969
                                        )
                                    )
                                    Text(
                                        sectionDot.value,
                                        fontFamily = Nunito,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        lineHeight = 18.5.sp,
                                        color = Color(
                                            0xFF707070
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(12.dp))
                                }
                            }
                            Spacer(modifier = Modifier.height(24.dp))

                        }
                    }
                }


            }


        }

        Spacer(modifier = Modifier.height(8.dp))
    }






    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState,
            shape = RectangleShape,
            containerColor = Color.White,
            dragHandle = { ProfileDragHandler() }
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFF323232)),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text("CLOSE",             fontFamily = Nunito,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal, color = Color(0xFF323232),
                    modifier = Modifier.padding(horizontal = 18.dp, vertical = 4.dp))

                Text(
                    "QR",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.Medium
                )


                Text(
                    "CLOSE",
                    fontFamily = Nunito,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 14.dp)
                        .clickable(onClick = {
                            scope.launch {
                                sheetState.hide()
                                delay(100)
                                showSheet = false
                            }
                        })
                )
            }




                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 38.dp)
                        .height(500.dp),
                    //  verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painterResource(R.drawable.profileqr),
                        contentDescription = null,
                        modifier = Modifier.size(300.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
                        drawerDetails.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                   // .padding(horizontal = 18.dp, vertical = 2.dp)
                                    .padding(end = 68.dp)
                            ) {
                                Text(
                                    item.key,
                                    modifier = Modifier.width(88.dp),
                                    fontFamily = Nunito,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Text(
                                    item.value,
                                    fontFamily = Nunito,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 16.sp
                                )

                            }
                        }

                    }


                }

            }

        }


    LoadingOverlay(isGeneral = false)

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showSystemUi = true)
    @Composable
    fun MyPreview() {
        ProfileScreen(navController = rememberNavController())
    }