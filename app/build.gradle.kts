plugins {
    id("com.android.application")
}

android {
    namespace = "com.playjava.launcher"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.playjava.launcher"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
