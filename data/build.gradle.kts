plugins {
    id(Dependencies.BUILDPLUGINS.ANDROID_LIBRARY_PLUGIN)
    id(Dependencies.BUILDPLUGINS.KOTLIN_ANDROID_PLUGIN)
    id(Dependencies.BUILDPLUGINS.KOTLIN_KAPT)
    id(Dependencies.BUILDPLUGINS.DAGGER_HILT)
}

android {
    compileSdk = ProjectProperties.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectProperties.MIN_SDK
        targetSdk = ProjectProperties.TARGET_SDK

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

    /* Kotlin */
    api(Dependencies.KOTLIN.KT_STD)
    api(Dependencies.ASYNC.COROUTINES)

    /* Dagger Hilt */
    api(Dependencies.DI.HILT_ANDROID)
    implementation(project(mapOf("path" to ":domain")))

    kapt(Dependencies.DI.HILT_ANDROID_COMPILER)

    /* Room */
    implementation(Dependencies.ANDROID.ROOM)
    implementation(Dependencies.ANDROID.ROOM_KTX)
    kapt(Dependencies.ANDROID.ROOM_COMPILER)

    /* Test */
    testImplementation(Dependencies.TEST.JUNIT)
    androidTestImplementation(Dependencies.TEST.EXT_JUNIT)
    androidTestImplementation(Dependencies.TEST.ANDROID_JUNIT)
    androidTestImplementation(Dependencies.TEST.ARCH_CORE)
    androidTestImplementation(Dependencies.TEST.COROUTINES_TEST)
    androidTestImplementation(Dependencies.TEST.ANDROID_TEST_RUNNER)
}
