// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Dependencies.BUILDPLUGINS.TOOLS_BUILD_GRADLE)
        classpath(Dependencies.BUILDPLUGINS.DAGGER_HILT_PLUGIN)
        classpath(Dependencies.BUILDPLUGINS.KOTLIN_GRADLE_PLUGIN)
        classpath(kotlin("serialization", version = Dependencies.VERSIONS.KOTLIN_VERSION))
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}
