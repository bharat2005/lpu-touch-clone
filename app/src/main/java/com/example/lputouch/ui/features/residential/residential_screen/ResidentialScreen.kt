package com.example.lputouch.ui.features.residential.residential_screen

import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.lputouch.ui.components.generalTopBar.GeneralTopbar
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.lputouch.ui.components.LoadingOverlay.LoadingOverlay
import com.example.lputouch.BuildConfig


@ExperimentalMaterial3Api
@Composable
fun ResidentialScreen(navController: NavController) {






    Scaffold(
        topBar = { GeneralTopbar(navController, title = "Residential Reporting Slip" ) }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

            AndroidView(
                modifier = Modifier.fillMaxSize().background(Color.White),
                factory = {
                        context ->

                    val webView = WebView(context)
                    webView.settings.javaScriptEnabled = true

                    webView.webViewClient = object : WebViewClient() {
                        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                            handler?.proceed()
                        }

                        override fun onPageFinished(view: WebView, url: String) {
                            super.onPageFinished(view, url)

                            val script = """
                    javascript:(function() {
                    
                        const slipElement = document.getElementById('ctl00_cphHeading_lblSlipNo');
                        if (slipElement) {
                            slipElement.textContent = '00000000';
                        }
                        
                        const imageElement = document.getElementById('ctl00_cphHeading_GridView1_ctl02_Image1');
                        if (imageElement) {
                            imageElement.src = 'https://tse2.mm.bing.net/th/id/OIP.FYA1sc0wKr42RwjQJ5_GTAHaLM?rs=1&pid=ImgDetMain&o=7&rm=3';
                        }
                        
                        const regElement = document.getElementById('ctl00_cphHeading_lblRegNo');
                        if (regElement) {
                            regElement.textContent = '12345678';
                        }
                        
                        const addressElement = document.getElementById('ctl00_cphHeading_lblAddress');
                        if (addressElement) {
                            addressElement.textContent = 'ArosafiF City :Ilorrichdag120393 District :Ilorrichdag State :MaharashtraCountry :India';
                        }
                        
                        const hostelEelemt = document.getElementById('ctl00_cphHeading_lblHostel');
                        if (hostelEelemt) {
                            hostelEelemt.textContent = 'Boys Hostel-99';
                        }
                        
                        const seaterEleemnt = document.getElementById('ctl00_cphHeading_lblSeater');
                        if (seaterEleemnt) {
                            seaterEleemnt.textContent = 'Std AC 9 Seater';
                        }
                        
                        const roomElement = document.getElementById('ctl00_cphHeading_lblRoomNo');
                        if (roomElement) {
                            roomElement.textContent = 'A999-Bed X';
                        }
                        
                        const messNameElement = document.getElementById('ctl00_cphHeading_lblMessName');
                        if (messNameElement) {
                            messNameElement.textContent = 'Same Hostel Mess';
                        }
        
                    })();
                """.trimIndent()
                            view.evaluateJavascript(script, null)
                        }



                    }
                    webView
                },
                update = { webView ->
                    webView.loadUrl("https://ums.lpu.in/lpuums/frmResidentailReportingSlip.aspx?uid=${BuildConfig.MY_UID}")
                }
            )

        }
    }

    LoadingOverlay(isGeneral = false)
}