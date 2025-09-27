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