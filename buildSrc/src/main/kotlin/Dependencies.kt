import Dependencies.VERSIONS.COMPOSE_COIL_VERSION
import Dependencies.VERSIONS.COMPOSE_VERSION
import Dependencies.VERSIONS.COROUTINES_VERSION
import Dependencies.VERSIONS.DAGGER_VERSION
import Dependencies.VERSIONS.KOTLIN_VERSION
import Dependencies.VERSIONS.KTX_CORE_VERSION
import Dependencies.VERSIONS.LIFECYCLE_VERSION
import Dependencies.VERSIONS.NAV_VERSION
import Dependencies.VERSIONS.SPLASH_SCREEN_VERSION

object Dependencies {
    object VERSIONS {
        const val COMPOSE_VERSION = "1.2.0"
        const val DAGGER_VERSION = "2.43"
        const val KOTLIN_VERSION = "1.7.0"
        const val KTX_CORE_VERSION = "1.7.0"
        const val COMPOSE_COMPILER_VERSION = COMPOSE_VERSION
        const val SPLASH_SCREEN_VERSION = "1.0.0-rc01"
        const val LIFECYCLE_VERSION = "2.5.0"
        const val NAV_VERSION = "2.5.1"
        const val COMPOSE_COIL_VERSION = "2.1.0"
        const val COROUTINES_VERSION = "1.6.0"
    }

    object BUILDPLUGINS {
        private const val TOOLS_BUILD = "7.2.1"
        private const val KT_LINT = "9.2.1"
        private const val SAFE_ARGS = "2.3.5"

        const val TOOLS_BUILD_GRADLE = "com.android.tools.build:gradle:$TOOLS_BUILD"
        const val KTLINT_GRADLE_PLUGIN = "org.jlleitschuh.gradle:ktlint-gradle:$KT_LINT"
        const val DAGGER_HILT_PLUGIN =
            "com.google.dagger:hilt-android-gradle-plugin:$DAGGER_VERSION"
        const val KOTLIN_GRADLE_PLUGIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
        const val ANDROID_APPLICATION_PLUGIN = "com.android.application"
        const val ANDROID_LIBRARY_PLUGIN = "com.android.library"
        const val KOTLIN_ANDROID_PLUGIN = "kotlin-android"
        const val KOTLIN_PARCELABLE_PLUGIN = "kotlin-parcelize"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val KTLINT = "org.jlleitschuh.gradle.ktlint"
        const val DAGGER_HILT = "dagger.hilt.android.plugin"
        const val SAFE_ARGS_KOTLIN = "androidx.navigation.safeargs.kotlin"
    }

    object KOTLIN {
        const val KT_STD = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN_VERSION"
        const val KTX_CORE = "androidx.core:core-ktx:$KTX_CORE_VERSION"
        const val DATE_TIME = "org.jetbrains.kotlinx:kotlinx-datetime:0.3.2"
    }

    object COMPOSE {
        private const val ACCOMPANIST_VERSION = "0.24.13-rc"
        const val COMPOSE_UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
        const val COMPOSE_MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
        const val COMPOSE_UI_TOOLING_PREVIEW =
            "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:$COMPOSE_VERSION"
        const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:$COMPOSE_VERSION"
        const val COMPOSE_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:$COMPOSE_VERSION"
        const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:$NAV_VERSION"
        const val COIL_COMPOSE = "io.coil-kt:coil-compose:$COMPOSE_COIL_VERSION"
        const val ACCOMPANIST_COIL = "com.google.accompanist:accompanist-coil:0.14.0"
        const val ACCOMPANIST_PAGER =
            "com.google.accompanist:accompanist-pager:$ACCOMPANIST_VERSION"
        const val ACCOMPANIST_PAGER_INDICATOR =
            "com.google.accompanist:accompanist-pager-indicators:$ACCOMPANIST_VERSION"
        const val COLLAPSIBLE_TOOLBAR = "me.onebone:toolbar-compose:2.3.4"
    }

    object ANDROID {
        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
        const val LIFECYCLE_VIEWMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
        const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel:$LIFECYCLE_VERSION"
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.0-beta01"
        const val SPLASH_SCREEN = "androidx.core:core-splashscreen:$SPLASH_SCREEN_VERSION"
    }

    object TEST {
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
        const val JUNIT = "junit:junit:4.13.2"
        const val EXT_JUNIT = "androidx.test.ext:junit:1.1.3"
    }

    object DI {
        const val HILT_ANDROID = "com.google.dagger:hilt-android:$DAGGER_VERSION"
        const val HILT_ANDROID_COMPILER =
            "com.google.dagger:hilt-android-compiler:$DAGGER_VERSION"
        const val HILT_COMPILER = "androidx.hilt:hilt-compiler:1.0.0"
        const val HILT_NAVIGATION_COMPOSE = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val HILT_CORE = "com.google.dagger:hilt-core:$DAGGER_VERSION"
    }

    object ASYNC {
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
    }
}
