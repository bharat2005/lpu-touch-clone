import org.jetbrains.kotlin.fir.expressions.builder.buildCatch

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.lputouch"
    compileSdk = 36



    buildFeatures {
        compose = true
        buildConfig = true
    }


    defaultConfig {
        applicationId = "com.example.lputouch"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val uid: String? = project.findProperty("MY_UID") as? String
        buildConfigField("String", "MY_UID", "\"$uid\"")

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation("androidx.navigation:navigation-compose:2.9.3")

    implementation("com.github.skydoves:flexible-bottomsheet-material:0.1.5")
    implementation("com.github.skydoves:flexible-bottomsheet-material3:0.1.5")

    implementation("androidx.webkit:webkit:1.14.0")

    implementation("com.google.accompanist:accompanist-swiperefresh:0.36.0")

    implementation("com.airbnb.android:lottie-compose:6.6.7")

    implementation("com.google.accompanist:accompanist-permissions:0.37.3")


    implementation("androidx.camera:camera-core:${"1.3.0-alpha06"}")
    implementation("androidx.camera:camera-camera2:${"1.3.0-alpha06"}")
    implementation("androidx.camera:camera-lifecycle:${"1.3.0-alpha06"}")
    implementation("androidx.camera:camera-view:${"1.3.0-alpha06"}")


    implementation("io.github.dokar3:sheets-m3:latest_version")

    implementation("io.github.dokar3:sheets-m3:0.6.0-alpha05")

    implementation("androidx.biometric:biometric:1.4.0-alpha04")

    implementation("com.google.accompanist:accompanist-navigation-animation:0.35.0-alpha")


    implementation("androidx.datastore:datastore-preferences:1.1.7")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")

    implementation("androidx.core:core-splashscreen:1.0.1")


    implementation("com.google.android.exoplayer:exoplayer:2.19.1")



}




























































