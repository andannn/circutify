plugins {
    id("circutify.android.library")
    id("circutify.android.serialization")
}

android {
    namespace = "com.andannn.circutiry.core.network"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        resValue("string", "CLIENT_ID", "c2ec58c8300a4556a6ed7f7be9a49be8")
        resValue("string", "REDIRECT_URI", "circutify://andannn.circutify.com")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.resources)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
}
