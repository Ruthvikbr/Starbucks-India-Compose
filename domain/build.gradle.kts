plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(Dependencies.KOTLIN.KT_STD)
    api(Dependencies.ASYNC.COROUTINES)
    implementation(Dependencies.DI.HILT_CORE)
}
