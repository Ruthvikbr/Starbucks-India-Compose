plugins {
    id(Dependencies.BUILDPLUGINS.ANDROID_LIBRARY_PLUGIN)
    id(Dependencies.BUILDPLUGINS.KOTLIN_ANDROID_PLUGIN)
    id(Dependencies.BUILDPLUGINS.KOTLIN_KAPT)
}

android {
    namespace = (ProjectProperties.NAVIGATION_NAMESPACE)
    compileSdk = (ProjectProperties.COMPILE_SDK)

    defaultConfig {
        minSdk = (ProjectProperties.MIN_SDK)
        targetSdk = (ProjectProperties.TARGET_SDK)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(Dependencies.ANDROID.APP_COMPAT)
    implementation(Dependencies.KOTLIN.KTX_CORE)
    api(Dependencies.ASYNC.COROUTINES)
    api(Dependencies.ASYNC.COROUTINES_ANDROID)

    implementation(Dependencies.KOTLIN.KT_STD)
    implementation(Dependencies.COMPOSE.COMPOSE_NAVIGATION)
    implementation(Dependencies.DI.HILT_NAVIGATION_COMPOSE)
}
