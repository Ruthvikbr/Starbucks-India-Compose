plugins {
    id(Dependencies.BUILDPLUGINS.ANDROID_APPLICATION_PLUGIN)
    id(Dependencies.BUILDPLUGINS.KOTLIN_ANDROID_PLUGIN)
    id(Dependencies.BUILDPLUGINS.KOTLIN_PARCELABLE_PLUGIN)
    id(Dependencies.BUILDPLUGINS.KOTLIN_KAPT)
    id(Dependencies.BUILDPLUGINS.DAGGER_HILT)
}

android {
    compileSdk = (ProjectProperties.COMPILE_SDK)

    defaultConfig {
        applicationId = (ProjectProperties.APPLICATION_ID)
        minSdk = (ProjectProperties.MIN_SDK)
        targetSdk = (ProjectProperties.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-common.txt",
                "proguard-specific.txt"
            )
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.VERSIONS.COMPOSE_COMPILER_VERSION
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.VERSIONS.COMPOSE_COMPILER_VERSION
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

kapt {
    generateStubs = true
    correctErrorTypes = true
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":navigation")))
    implementation(Dependencies.COMPOSE.COMPOSE_UI)
    implementation(Dependencies.COMPOSE.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.COMPOSE.ACTIVITY_COMPOSE)
    implementation(Dependencies.COMPOSE.COMPOSE_NAVIGATION)

    testImplementation(Dependencies.TEST.JUNIT)
    testImplementation(Dependencies.TEST.COROUTINES_TEST)
    androidTestImplementation(Dependencies.TEST.EXT_JUNIT)
    androidTestImplementation(Dependencies.TEST.ESPRESSO_CORE)
    androidTestImplementation(Dependencies.COMPOSE.COMPOSE_JUNIT)
    debugImplementation(Dependencies.COMPOSE.COMPOSE_TOOLING)
    debugImplementation(Dependencies.COMPOSE.COMPOSE_TEST_MANIFEST)

    implementation(Dependencies.ANDROID.APP_COMPAT)
    implementation(Dependencies.KOTLIN.KTX_CORE)
    implementation(Dependencies.ANDROID.SPLASH_SCREEN)
    implementation(Dependencies.ANDROID.LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.ANDROID.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Dependencies.ANDROID.LIFECYCLE_VIEWMODEL)

    /*DAGGER HILT*/
    implementation(Dependencies.DI.HILT_ANDROID)
    implementation(Dependencies.DI.HILT_NAVIGATION_COMPOSE)
    kapt(Dependencies.DI.HILT_COMPILER)
    kapt(Dependencies.DI.HILT_ANDROID_COMPILER)

    /* Coil */
    implementation(Dependencies.COMPOSE.COIL_COMPOSE)
    implementation(Dependencies.COMPOSE.ACCOMPANIST_COIL)

    /* Async */
    implementation(Dependencies.ASYNC.COROUTINES)
    implementation(Dependencies.ASYNC.COROUTINES_ANDROID)

    implementation(Dependencies.COMPOSE.ACCOMPANIST_PAGER)
    implementation(Dependencies.COMPOSE.ACCOMPANIST_PAGER_INDICATOR)
    implementation(Dependencies.COMPOSE.COLLAPSIBLE_TOOLBAR)
}
