package com.example.lputouch.ui.features.main.side_drawer.componets.drawerProfileView

import androidx.camera.core.ViewPort
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import com.example.lputouch.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lputouch.ui.theme.Nunito
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DrawerProfileSection(navController: NavController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(256.dp)
            .shadow(4.dp)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFFFF8278),
                        Color(0xFFFCCC6A)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .padding(top = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
           // verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(95.dp)
                    .clip(CircleShape)
                    .clickable(
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                delay(300)
                                navController.navigate("profile")
                            }

                        },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() })
                    .background(Color.Black)
                    .shadow(18.dp, shape = CircleShape, clip = false )
            ) {
                Image(
                    painterResource(R.drawable.me), contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
            Spacer(modifier = Modifier.height(10.dp))


            Text(
                "Deshmukh Bharat Vasanta",
                fontFamily = Nunito,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Text("12345678", fontFamily = Nunito, fontWeight = FontWeight.Medium, fontSize = 14.2.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF1C1C1C),
                modifier = Modifier.padding(vertical = 2.dp)
                )

            Text(
                "P132:B.Tech. (Computer Science and Engineering)(2024)",
                fontFamily = Nunito,
                fontWeight = FontWeight.Medium,
                fontSize = 14.2.sp,
                lineHeight = 17.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF1C1C1C)
            )

        }

    }

}