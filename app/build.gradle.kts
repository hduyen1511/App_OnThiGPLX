plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.GPLX"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.GPLX"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    //noinspection GradleCompatible,GradleCompatible
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //barrenechea androidx
    implementation ("ca.barrenechea.header-decor:header-decor:0.2.8")
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.27")
    implementation ("me.everything:overscroll-decor-android:1.0.4")
    implementation ("com.bartoszlipinski:recyclerviewheader2:2.0.1")
    implementation ("com.intuit.sdp:sdp-android:1.1.0")
    implementation ("com.intuit.ssp:ssp-android:1.1.0")

    //readystatesoftware
    implementation ("com.readystatesoftware.sqliteasset:sqliteassethelper:2.0.1")
    //com.google.android.gms.ads
    //InterstitialAd
    //StickyHeaderAdapter androidx
}