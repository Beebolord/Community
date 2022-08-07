plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
}
val composeVersion = "1.2.0"
android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.forest.community.android"
        minSdk = 28
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose =  true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    // Integration with activities
    implementation ("androidx.activity:activity-compose:1.4.0")
    // Compose Material Design// Animations
    implementation ("androidx.compose.animation:animation:1.1.1")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-tooling:1.1.1")
    // Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    implementation("com.google.android.gms:play-services-auth:20.2.0")
    // UI Tests
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.1.1")
    //Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0")
    implementation("androidx.compose.material:material:1.2.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.2.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.2.0")
    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation ("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")

    //Firebase
    implementation ("com.google.firebase:firebase-auth-ktx:21.0.6")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.3.9")

}