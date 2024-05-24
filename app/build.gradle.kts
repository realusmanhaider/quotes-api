plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.quotesapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quotesapi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

     //   multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation (libs.sdp.android)
    // Kotlin Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // ViewModel
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation (libs.androidx.lifecycle.livedata.ktx)
    // Lifecycles only (without ViewModel or LiveData)
    implementation (libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.adapter.rxjava)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation(libs.converter.gson)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation(libs.glide)
    implementation(libs.hilt.android)
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


}

