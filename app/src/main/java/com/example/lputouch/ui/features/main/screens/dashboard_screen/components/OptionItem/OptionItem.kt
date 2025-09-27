package com.example.lputouch.ui.features.main.screens.dashboard_screen.components.OptionItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lputouch.data.model.TileOption
import com.example.lputouch.R
import com.example.lputouch.ui.theme.Nunito
import com.skydoves.flexible.core.InternalFlexibleApi
import com.skydoves.flexible.core.toPx

@OptIn(InternalFlexibleApi::class)
@Composable
fun OptionItem(tile: TileOption, navController: NavController) {

    Box(
        modifier = Modifier
            .height(144.dp)
            .width(114.dp)
            .clickable(
                onClick = {

                },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        // Card body
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer(
                    shadowElevation = 3.dp.toPx(),
                    shape = RoundedCornerShape(8.dp),
                    clip = true,
                    translationY = 18.dp.toPx(),
                    translationX = 0.dp.toPx()

                )
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFFEFAEE))
                .border(0.05.dp, Color(0xFFE1E1E1), shape = RoundedCornerShape(8.dp))
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(tile.image),
                    contentDescription = null,
                    modifier = Modifier.size(68.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp, horizontal = 3.dp)
                        .background(
                            Color(0xFFFFC890),
                            shape = RoundedCornerShape(5.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        tile.title,
                        fontFamily = Nunito,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        lineHeight = 14.5.sp
                    )
                }
            }
        }

        // Badge
        if (tile.value.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 6.dp, y = (4).dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFFF7361),
                                Color(0xFFFCCC6A)
                            )
                        ),
                    )
                    .padding(horizontal = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tile.value,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
            }
        }
    }


}